package cn.jackiegu.oop.design.principle.law.of.demeter;

import java.io.Serializable;

/**
 * 内部员工
 *
 * @author JackieGu
 * @date 2021/5/18
 */
public class InnerEmployee implements Serializable {

    private static final long serialVersionUID = 7851782470225501429L;

    private String id;

    private String name;

    public InnerEmployee() {
    }

    public InnerEmployee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InnerEmployee{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
