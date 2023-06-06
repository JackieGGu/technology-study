package cn.jackiegu.oop.design.principle.liskov.substitution;

/**
 * 用户行为接口
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public interface IUser {

    String getName();

    void setName(String name);

    String getMobileNo();

    void setMobileNo(String mobileNo);
}
