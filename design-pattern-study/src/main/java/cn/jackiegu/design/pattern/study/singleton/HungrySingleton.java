package cn.jackiegu.design.pattern.study.singleton;

/**
 * 饿汉式
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
