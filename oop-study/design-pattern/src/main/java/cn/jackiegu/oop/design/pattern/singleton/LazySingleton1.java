package cn.jackiegu.oop.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式一
 *
 * @author JackieGu
 * @date 2021/5/27
 */
@Slf4j
public class LazySingleton1 {

    private static LazySingleton1 instance;

    private LazySingleton1() {
        if (instance == null) {
            log.info("LazySingleton1 Instancing");
        } else {
            // 防止反射破坏
            throw new RuntimeException("Singleton instances are forbidden from being instantiated again");
        }
    }

    /**
     * 直接对方法加锁, 保证同一时刻方法内部只有一个线程在执行, 但性能较差
     * 若去掉synchronized关键字, 在并发情况下很容易被创建出多个实例
     * 虽然都会被最后一个实例给覆盖, 但那些被覆盖实例无疑是在浪费资源和增大GC压力
     */
    @SuppressWarnings("all")
    public static synchronized LazySingleton1 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
            instance = new LazySingleton1();
        }
        return instance;
    }
}
