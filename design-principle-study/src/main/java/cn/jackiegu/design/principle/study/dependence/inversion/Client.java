package cn.jackiegu.design.principle.study.dependence.inversion;

import cn.jackiegu.design.principle.study.dependence.inversion.original.Benz;
import cn.jackiegu.design.principle.study.dependence.inversion.original.Bike;
import cn.jackiegu.design.principle.study.dependence.inversion.original.Bmw;
import cn.jackiegu.design.principle.study.dependence.inversion.original.Driver;
import cn.jackiegu.design.principle.study.dependence.inversion.original.IDriver;
import cn.jackiegu.technology.common.util.LoggerUtil;

/**
 * 客户端
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public class Client {

    public static void main(String[] args) {
        IDriver tom = new Driver(new Benz());
        LoggerUtil.info("tom: ");
        tom.driver();
        tom.changeCar(new Bike());
        tom.driver();
        IDriver jerry = new Driver(new Bmw());
        LoggerUtil.info("jerry: ");
        jerry.driver();

        LoggerUtil.info("audi car: ");
        ICar audiCar = new AudiCar();
        AutoDriveSystem audiCarAutoDriveSystem = new AutoDriveSystem(audiCar);
        audiCarAutoDriveSystem.drive();
        audiCarAutoDriveSystem.turn();
        audiCarAutoDriveSystem.brake();


    }
}
