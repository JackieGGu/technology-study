package cn.jackiegu.oop.design.principle.dependence.inversion;

/**
 * 奔驰汽车
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public class BenzCar {

    public void drive() {
        System.out.println("奔驰汽车正在被驾驶");
    }

    public void turn() {
        System.out.println("奔驰汽车正在被转向");
    }

    public void brake() {
        System.out.println("奔驰汽车正在被刹车");
    }
}
