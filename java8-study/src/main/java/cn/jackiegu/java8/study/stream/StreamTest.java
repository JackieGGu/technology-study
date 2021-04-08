package cn.jackiegu.java8.study.stream;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.security.SecureRandom;
import java.time.LocalDate;
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
        Arrays.stream(entities).forEach(System.out::println);

        // 采用Arrays.stream(T[] array)方法创建Stream
        // 对id大于10的进行过滤
        // 按照date进行从小到大排序
        // 将结果放入一个List中
        LoggerUtil.info("处理数据1");
        List<StreamEntity> list1 = Arrays.stream(entities)
            .filter(item -> item.getId() < 10)
            .sorted(StreamEntity::compare)
            .collect(Collectors.toList());
        list1.forEach(System.out::println);

        // 采用Collection.stream()的默认方法创建Stream
        // 按照id进行去重, 注意distinct去重必须要求实体类重写hashCode和equals两个方法
        LoggerUtil.info("处理数据2");
        List<StreamEntity> list2 = list1.stream()
            .distinct()
            .collect(Collectors.toList());
        list2.forEach(System.out::println);

        // 采用Stream.of(T... t)方法创建Stream
        LoggerUtil.info("处理数据3");
        Object[] array1 = Stream.of("zs", "ls", "ww", "zl", "qq")
            .map(item -> item.charAt(0))
            .toArray();
        Arrays.stream(array1).forEach(System.out::println);

        // 中间操作是延迟加载的, 只有当最终操作存在的时候中间操作才会执行
        // stream的执行实际上是每一个元素沿着链垂直移动的, 也就是说当前一个元素将执行链完成后才会开始第二个元素
        LoggerUtil.info("中间操作的延迟加载");
        Arrays.stream(array1)
            .filter(item -> {
                System.out.println("filter: " + item);
                return true;
            })
            .forEach(System.out::println);


    }

}
