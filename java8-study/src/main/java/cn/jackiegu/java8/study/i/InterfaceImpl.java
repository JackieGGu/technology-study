package cn.jackiegu.java8.study.i;

/**
 * 接口实现类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class InterfaceImpl implements InterfaceA, InterfaceB {

    @Override
    public void sayHi(String name) {
        System.out.println("hi " + name);
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public void defaultMethod() {
        System.out.println("TestInterfaceImpl defaultMethod");
    }
}

class InterfaceAImpl implements InterfaceA {

    @Override
    public void sayHi(String name) {
        System.out.println("hi " + name);
    }
}

class InterfaceBImpl implements InterfaceB {

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);

    }
}
