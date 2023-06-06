package cn.jackiegu.oop.design.principle.law.of.demeter;

import java.io.Serializable;

/**
 * 外派员工
 *
 * @author JackieGu
 * @date 2021/5/18
 */
public class OuterEmployee implements Serializable {

    private static final long serialVersionUID = -9026013823532683124L;

    private String id;

    private String name;

    public OuterEmployee() {
    }

    public OuterEmployee(String id, String name) {
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
        return "OuterEmployee{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
