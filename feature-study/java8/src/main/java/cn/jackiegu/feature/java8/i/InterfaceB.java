package cn.jackiegu.feature.java8.i;

/**
 * 测试接口B
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@SuppressWarnings("all")
public interface InterfaceB {

    void sayHello(String name);

    default void defaultMethod() {
        System.out.println("TestInterfaceB defaultMethod");
    }

    static void staticMethod() {
        System.out.println("TestInterfaceB staticMethod");
    }
}
