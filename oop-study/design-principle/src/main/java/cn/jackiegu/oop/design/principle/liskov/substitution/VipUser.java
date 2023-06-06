package cn.jackiegu.oop.design.principle.liskov.substitution;

/**
 * VIP用户
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class VipUser implements IUser {

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
