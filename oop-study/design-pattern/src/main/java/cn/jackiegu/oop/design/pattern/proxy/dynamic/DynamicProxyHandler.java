package cn.jackiegu.oop.design.pattern.proxy.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author JackieGu
 * @date 2020/10/11
 */
@Slf4j
public class DynamicProxyHandler implements InvocationHandler {

    private final Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object result = method.invoke(object, args);
        this.after();
        return result;
    }

    /**
     * 代理对象方法扩展
     */
    private void before() {
        log.info("before...");
    }

    /**
     * 代理对象方法扩展
     */
    private void after() {
        log.info("after...");
    }
}
