package cn.jackiegu.design.pattern.study.singleton;

/**
 * 懒汉式二
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class LazySingleton2 {

    private final String name;

    private static volatile LazySingleton2 instance;

    private LazySingleton2() {
        this.name = "LazySingleton2";
    }

    public static LazySingleton2 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton2.class) {
                if (instance == null) {
                    instance = new LazySingleton2();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }
}
