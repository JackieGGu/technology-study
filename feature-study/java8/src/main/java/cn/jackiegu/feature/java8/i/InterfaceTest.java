package cn.jackiegu.feature.java8.i;

import cn.jackiegu.technology.common.util.LoggerUtil;

/**
 * 接口测试类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class InterfaceTest {

    public static void main(String[] args) {
        LoggerUtil.info("InterfaceAImpl");
        InterfaceA a = new InterfaceAImpl();
        a.sayHi("小球球");
        a.defaultMethod();

        LoggerUtil.info("InterfaceBImpl");
        InterfaceB b = new InterfaceBImpl();
        b.sayHello("little qiuqiu");
        b.defaultMethod();

        LoggerUtil.info("InterfaceImpl");
        InterfaceImpl i = new InterfaceImpl();
        i.sayHi("小狗狗");
        i.sayHello("little dog");
        i.defaultMethod();

        LoggerUtil.info("Static Method");
        InterfaceA.staticMethod();
        InterfaceB.staticMethod();
    }
}
