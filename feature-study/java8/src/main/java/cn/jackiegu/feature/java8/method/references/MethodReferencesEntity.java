package cn.jackiegu.feature.java8.method.references;

import java.time.LocalDate;

/**
 * 测试实体类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
public class MethodReferencesEntity {

    private String name;

    private LocalDate birthday;

    public MethodReferencesEntity() {
    }

    public MethodReferencesEntity(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public static int compareTo(MethodReferencesEntity a, MethodReferencesEntity b) {
        return a.birthday.compareTo(b.birthday);
    }

    public boolean isBirthdaySame(MethodReferencesEntity entity) {
        return this.birthday.equals(entity.getBirthday());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + ":" + birthday;
    }
}
