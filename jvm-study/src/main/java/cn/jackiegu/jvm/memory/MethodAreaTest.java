package cn.jackiegu.jvm.memory;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区测试
 * VM Args: -XX:MetaspaceSize=32m -XX:MaxMetaspaceSize=32m
 *
 * @author JackieGu
 * @date 2021/5/6
 */
@Slf4j
public class MethodAreaTest {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args));
                enhancer.create();
            }
        } catch (Error e) {
            log.info("i: {}", i, e);
        }
    }
}

class OOM {

}