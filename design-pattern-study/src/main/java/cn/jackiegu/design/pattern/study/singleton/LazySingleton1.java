package cn.jackiegu.design.pattern.study.singleton;

/**
 * 懒汉式一
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class LazySingleton1 {

    private static LazySingleton1 instance;

    private LazySingleton1() {

    }

    public synchronized static LazySingleton1 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            instance = new LazySingleton1();
        }
        return instance;
    }
}
