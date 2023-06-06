package cn.jackiegu.oop.design.principle.dependence.inversion;

/**
 * 宝马汽车
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public class BmwCar implements ICar {

    @Override
    public void drive() {
        System.out.println("宝马汽车正在被驾驶");
    }

    @Override
    public void turn() {
        System.out.println("宝马汽车正在被转向");
    }

    @Override
    public void brake() {
        System.out.println("宝马汽车正在被刹车");
    }
}
