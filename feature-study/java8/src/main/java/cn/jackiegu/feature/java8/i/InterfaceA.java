package cn.jackiegu.feature.java8.i;

/**
 * 测试接口A
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@SuppressWarnings("all")
public interface InterfaceA extends InterfaceSuper {

    void sayHi(String name);

    @Override
    default void defaultMethod() {
        System.out.println("TestInterfaceA defaultMethod");
    }

    static void staticMethod() {
        System.out.println("TestInterfaceA staticMethod");
    }
}
