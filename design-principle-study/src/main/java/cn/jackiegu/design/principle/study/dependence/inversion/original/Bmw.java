package cn.jackiegu.design.principle.study.dependence.inversion.original;

/**
 * 宝马汽车
 *
 * @author JackieGu
 * @date 2020/9/21
 */
public class Bmw implements ICar {

    @Override
    public void run() {
        System.out.println("宝马汽车开始运行");
    }
}
