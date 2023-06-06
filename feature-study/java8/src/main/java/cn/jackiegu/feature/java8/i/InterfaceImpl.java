package cn.jackiegu.feature.java8.i;

import lombok.extern.slf4j.Slf4j;

/**
 * 接口实现类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@Slf4j
public class InterfaceImpl implements InterfaceA, InterfaceB {

    @Override
    public void sayHi(String name) {
        log.info("hi {}", name);
    }

    @Override
    public void sayHello(String name) {
        log.info("hello {}", name);
    }

    @Override
    public void defaultMethod() {
        log.info("TestInterfaceImpl defaultMethod");
    }
}

@Slf4j
class InterfaceAImpl implements InterfaceA {

    @Override
    public void sayHi(String name) {
        log.info("hi {}", name);
    }
}

@Slf4j
class InterfaceBImpl implements InterfaceB {

    @Override
    public void sayHello(String name) {
        log.info("hello {}", name);
    }
}
