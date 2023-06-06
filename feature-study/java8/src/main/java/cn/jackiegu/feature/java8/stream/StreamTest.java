package cn.jackiegu.feature.java8.stream;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream测试类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@Slf4j
public class StreamTest {

    public static void main(String[] args) {
        Random random = new SecureRandom();
        StreamEntity[] entities = new StreamEntity[15];
        for (int i = 0; i < entities.length; i++) {
            int id = random.nextInt(15);
            int year = random.nextInt(40) + 1980;
            int number = random.nextInt(1000) + 1000;
            LocalDate date = LocalDate.of(year, (number % 12) + 1, (number % 28) + 1);
            entities[i] = new StreamEntity(id, date);
        }
        LoggerUtil.info("源数据");
        Arrays.stream(entities).forEach(item -> log.info(item.toString()));

        // 创建Stream之数组
        Stream<StreamEntity> stream1 = Arrays.stream(entities);
        // 创建Stream之集合
        List<StreamEntity> entityList = Arrays.asList(entities);
        Stream<StreamEntity> stream2 = entityList.stream();
        Stream<StreamEntity> stream3 = entityList.parallelStream();
        // 创建Stream之Stream静态方法
        Stream<StreamEntity> stream4 = Stream.of(entities);
        Stream<Integer> stream5 = Stream.iterate(1, item -> item + 1);
        Stream<Integer> stream6 = Stream.generate(() -> new SecureRandom().nextInt(100));
        Stream<Integer> stream7 = Stream.empty();

        // 中间操作
        LoggerUtil.info("中间操作之过滤和去重");
        stream1.filter(item -> item.getId() < 10)
            .distinct()
            .forEach(item -> log.info(item.toString()));
        LoggerUtil.info("中间操作之切片");
        stream5.limit(10)
            .skip(5)
            .forEach(item -> log.info(item.toString()));
        LoggerUtil.info("中间操作之映射");
        stream2.map(StreamEntity::getId)
            .filter(item -> item < 2)
            .flatMap(item -> {
                Integer[] arr = new Integer[item];
                if (arr.length > 0) {
                    arr[0] = 999;
                }
                return Arrays.stream(arr);
            })
            .forEach(item -> log.info(item.toString()));
        LoggerUtil.info("中间操作之排序");
        stream6.limit(10)
            .sorted()
            .forEach(item -> log.info(item.toString()));
        LoggerUtil.info("中间操作之延迟加载");
        @SuppressWarnings("all")
        Stream<Integer> stream8 = Stream.of(5, 1, 6, 8, 9, 4, 3, 2, 7)
            .filter(item -> {
                System.out.println("filter: " + item);
                return item < 5;
            })
            .map(item -> {
                System.out.println("map: " + item);
                return item * 2;
            })
            .sorted((a, b) -> {
                System.out.println("sort: " + a + " " + b);
                return a.compareTo(b);
            });
        // stream8.forEach(System.out::println);

        // 终止操作
        LoggerUtil.info("终止操作之查找");
        StreamEntity s1 = stream3.findAny().orElse(null);
        log.info(s1 == null ? null : s1.toString());
        LoggerUtil.info("终止操作之匹配");
        boolean b1 = stream4.anyMatch(item -> item.getId() == 1);
        log.info("{}", b1);
        LoggerUtil.info("终止操作之归纳");
        Integer sum = Stream.of(5, 1, 6, 8, 9, 4, 3, 2, 7).limit(5)
            .reduce(0, Integer::sum);
        log.info("{}", sum);
        LoggerUtil.info("终止操作之收集");
        List<Integer> l1 = Stream.of(5, 1, 6, 8, 9, 4, 3, 2, 7)
            .limit(5)
            .collect(Collectors.toCollection(ArrayList::new));
        log.info(l1.toString());
    }

}
