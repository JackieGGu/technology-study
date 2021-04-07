package cn.jackiegu.java8.study.method.references;

import java.util.function.Supplier;

/**
 * 测试实体类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
public class Cat {

    private String name;

    private Integer age;

    private String sex;

    public Cat() {
    }

    public Cat(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static Cat create(Supplier<Cat> supplier) {
        return supplier.get();
    }

    public static void call(Cat cat) {
        System.out.println(cat.getName() + ": 喵~~~");
    }

    public void repair(Cat cat) {
        System.out.println("repair: " + cat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Cat{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            '}';
    }
}
