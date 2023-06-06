package cn.jackiegu.feature.java8.method.references;

/**
 * 测试实体比较类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class MethodReferencesEntityCompare {

    public int compareByName(MethodReferencesEntity a, MethodReferencesEntity b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByBirthday(MethodReferencesEntity a, MethodReferencesEntity b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}
