package cn.jackiegu.feature.java8.method.references;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用测试类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
@Slf4j
public class MethodReferencesTest {

    public static void main(String[] args) {
        MethodReferencesEntity[] entities = new MethodReferencesEntity[]{
            new MethodReferencesEntity("张三", LocalDate.of(1993, 8, 5)),
            new MethodReferencesEntity("李四", LocalDate.of(1992, 7, 1)),
            new MethodReferencesEntity("王五", LocalDate.of(1995, 10, 28)),
            new MethodReferencesEntity("赵六", LocalDate.of(1994, 3, 15)),
            new MethodReferencesEntity("钱七", LocalDate.of(1992, 7, 1))
        };
        // 对象引用::实例方法名
        LoggerUtil.info("对象引用::实例方法名");
        MethodReferencesEntity[] e1 = entities.clone();
        MethodReferencesEntityCompare compare = new MethodReferencesEntityCompare();
        // Arrays.sort(e1, (a, b) -> compare.compareByBirthday(a, b));
        Arrays.sort(e1, compare::compareByBirthday);
        log.info(Arrays.toString(e1));

        // 类名::静态方法名
        LoggerUtil.info("类名::静态方法名");
        MethodReferencesEntity[] e2 = entities.clone();
        // Arrays.sort(e2, (a, b) -> a.getBirthday().compareTo(b.getBirthday()));
        Arrays.sort(e2, MethodReferencesEntity::compareTo);
        log.info(Arrays.toString(e2));

        // 类名::实例方法名
        LoggerUtil.info("类名::实例方法名");
        // BiPredicate<MethodReferencesEntity, MethodReferencesEntity> bp = (a, b) -> a.isBirthdaySame(b);
        BiPredicate<MethodReferencesEntity, MethodReferencesEntity> bp = MethodReferencesEntity::isBirthdaySame;
        log.info("{}", bp.test(entities[1], entities[4]));

        // 类名::new
        LoggerUtil.info("类名::new");
        // Supplier<MethodReferencesEntity> supplier = () -> new MethodReferencesEntity();
        Supplier<MethodReferencesEntity> supplier = MethodReferencesEntity::new;
        log.info("{}", supplier.get());

        // 类型[]::new
        LoggerUtil.info("类型[]::new");
        // Function<Integer, MethodReferencesEntity[]> function = i -> new MethodReferencesEntity[i];
        Function<Integer, MethodReferencesEntity[]> function = MethodReferencesEntity[]::new;
        log.info(Arrays.toString(function.apply(3)));
    }
}
