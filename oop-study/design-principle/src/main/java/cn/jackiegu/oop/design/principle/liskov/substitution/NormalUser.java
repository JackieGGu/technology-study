package cn.jackiegu.oop.design.principle.liskov.substitution;

/**
 * 普通用户
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class NormalUser implements IUser {

    private String name;

    private String mobileNo;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
