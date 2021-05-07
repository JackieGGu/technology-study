package cn.jackiegu.jvm.study.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区测试
 *
 * @author JackieGu
 * @date 2021/5/6
 */
public class MethodAreaTest {

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
            System.out.println(i);
            System.out.println(e);
        }
    }
}

class OOM {

}