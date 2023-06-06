package cn.jackiegu.oop.design.principle.liskov.substitution;

/**
 * 短信发送器
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class SmsSender {

    /**
     * 给用户发送短信
     *
     * @param user 用户
     */
    public void send(IUser user) {
        System.out.println("发送短信给用户: " + user.getMobileNo());
    }
}
