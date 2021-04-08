package cn.jackiegu.java8.study.i;

/**
 * 测试接口A
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public interface InterfaceA {

    void sayHi(String name);

    default void defaultMethod() {
        System.out.println("TestInterfaceA defaultMethod");
    }

    static void staticMethod() {
        System.out.println("TestInterfaceA staticMethod");
    }
}
