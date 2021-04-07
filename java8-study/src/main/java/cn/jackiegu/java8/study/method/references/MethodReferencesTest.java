package cn.jackiegu.java8.study.method.references;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用测试类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
public class MethodReferencesTest {

    public static void main(String[] args) {
        // 构造器引用
        LoggerUtil.info("构造器引用");
        // Cat cat1 = Cat.create(() -> new Cat());
        Cat cat1 = Cat.create(Cat::new);
        cat1.setName("球球1");
        cat1.setAge(4);
        cat1.setSex("男");
        System.out.println(cat1);

        // 静态方法引用
        LoggerUtil.info("静态方法引用");
        List<Cat> cats = Collections.singletonList(cat1);
        // cats.forEach(cat -> Cat.call(cat));
        cats.forEach(Cat::call);

        // 类的成员方法引用
        LoggerUtil.info("类的成员方法引用");
        Cat cat2 = new Cat("球球2", 4, "男");
        // Supplier<String> supplier = () -> qiuqiu.getName();
        Supplier<String> supplier = cat2::getName;
        System.out.println(supplier.get());

        // 对象引用::实例方法名
        LoggerUtil.info("对象引用::实例方法名");
        cats.forEach(cat1::repair);
    }
}
