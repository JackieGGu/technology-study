package cn.jackiegu.feature.java8.i;

/**
 * 测试接口顶层
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@SuppressWarnings("all")
public interface InterfaceSuper {

    default void defaultMethod() {
        System.out.println("InterfaceSuper defaultMethod");
    }
}
