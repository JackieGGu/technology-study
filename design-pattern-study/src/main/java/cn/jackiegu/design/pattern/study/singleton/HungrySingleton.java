package cn.jackiegu.design.pattern.study.singleton;

/**
 * 饿汉式
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class HungrySingleton {

    /**
     * 静态变量是在类被JVM加载时进行的初始化, 如: Class.forName(String className)方法
     * 由于JVM加载类时是线程安全的, 所以也保证了静态变量只会被初始化一次
     */
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("HungrySingleton Instancing");
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
