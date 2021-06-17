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
        if (instance == null) {
            System.out.println("HungrySingleton Instancing");
        } else {
            // 防止反射破坏
            throw new RuntimeException("Singleton instances are forbidden from being instantiated again");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    /**
     * 防止序列化破坏, 但底层JVM还是创建了一个新的实例对象
     */
    public Object readResolve() {
        return instance;
    }
}
