package cn.jackiegu.oop.design.pattern.factory.simple;

/**
 * 加法运算类
 *
 * @author JackieGu
 */
public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        return super.getNumberA() + super.getNumberB();
    }
}
