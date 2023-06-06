package cn.jackiegu.oop.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式三
 *
 * @author JackieGu
 * @date 2021/5/27
 */
@Slf4j
public class LazySingleton3 {

    private LazySingleton3() {
        if (Instance.INSTANCE == null) {
            log.info("LazySingleton3 Instancing");
        } else {
            // 防止反射破坏
            throw new RuntimeException("Singleton instances are forbidden from being instantiated again");
        }
    }

    /**
     * 使用私有的静态内部类, 原理与饿汉式一样, 只不过该内部类只有在getInstance()方法执行时才会被JVM加载, 所有也算是延迟加载
     */
    public static LazySingleton3 getInstance() {
        return Instance.INSTANCE;
    }

    private static class Instance {
        private static LazySingleton3 INSTANCE = new LazySingleton3();
    }
}
