package cn.jackiegu.oop.design.principle.composite.reuse;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5636611853879619342L;

    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", sex=" + sex;
    }
}
