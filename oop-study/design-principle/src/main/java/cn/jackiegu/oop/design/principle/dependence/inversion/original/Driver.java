package cn.jackiegu.oop.design.principle.dependence.inversion.original;

/**
 * 驾驶员类
 *
 * @author JackieGu
 * @date 2020/9/21
 */
public class Driver extends IDriver {

    public Driver(ICar car) {
        super.car = car;
    }

    @Override
    public void driver() {
        super.car.run();
    }
}
