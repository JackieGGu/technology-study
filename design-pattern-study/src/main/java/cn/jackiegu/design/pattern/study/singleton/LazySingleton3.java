package cn.jackiegu.design.pattern.study.singleton;

/**
 * 懒汉式三
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class LazySingleton3 {

    private LazySingleton3() {
    }

    public static LazySingleton3 getInstance() {
        return Instance.INSTANCE;
    }

    private static class Instance {
        private static LazySingleton3 INSTANCE = new LazySingleton3();
    }
}
