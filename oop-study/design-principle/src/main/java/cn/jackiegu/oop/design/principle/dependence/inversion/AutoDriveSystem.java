package cn.jackiegu.oop.design.principle.dependence.inversion;

/**
 * 自动驾驶系统
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public class AutoDriveSystem {

    private ICar car;

    public AutoDriveSystem(ICar car) {
        this.car = car;
    }

    public void drive() {
        car.drive();
    }

    public void turn() {
        car.turn();
    }

    public void brake() {
        car.brake();
    }
}
