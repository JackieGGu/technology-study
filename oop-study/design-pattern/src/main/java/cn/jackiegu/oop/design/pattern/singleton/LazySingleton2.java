package cn.jackiegu.oop.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式二
 *
 * @author JackieGu
 * @date 2021/5/27
 */
@Slf4j
public class LazySingleton2 {

    @SuppressWarnings("all")
    private static volatile LazySingleton2 instance;

    private LazySingleton2() {
        if (instance == null) {
            log.info("LazySingleton2 Instancing");
        } else {
            // 防止反射破坏
            throw new RuntimeException("Singleton instances are forbidden from being instantiated again");
        }
    }

    /**
     * 取消对方法进行加锁, 在方法内部对单例对象使用双重检查锁, 目的是降低锁的作用域范围, 提高性能
     * 再使用volatile关键字修饰单例对象, 目的是禁止对象的指令重排序
     *
     * 指令重排序:
     * 对象创建过程按照正常逻辑应该是以下顺序: 1 -> 2 -> 3 -> 4 -> 5
     * 当JVM产生指令重排序时, 执行顺序可能是这样的: 1 -> 2 -> 5 -> 3 -> 4 或者 1 -> 2 -> 3 -> 5 -> 4
     * 即对象还未完全创建完成, 变量名与对象内存的引用已经创建完成
     * 若此时thread1和thread2分别正运行到下面的位置, thread2正在执行第3步或者第4步时CPU时间片用完了, thread1拿到了CPU时间片
     * 判断instance == null结果为false, 直接返回该实例, 其实这个实例是还未完全创建完成的, 就会引起一些意想不到得问题
     */
    public static LazySingleton2 getInstance() {
        // thread1
        if (instance == null) {
            synchronized (LazySingleton2.class) {
                if (instance == null) {
                    /*
                     * 对象创建过程
                     * 1. 检查类是否被类加载器加载过
                     * 2. 分配堆中的一块内存给即将创建的对象
                     * 3. 初始化对象头
                     * 4. 执行构造函数
                     * 5. 创建变量名与对象实例内存的引用
                     */
                    // thread2 (已执行: 1 -> 2 -> 5, 正在执行: 3 或者 4)
                    instance = new LazySingleton2();
                }
            }
        }
        return instance;
    }
}
