package cn.jackiegu.design.pattern.study.factory.simple;

/**
 * 减法运算类
 *
 * @author JackieGu
 */
public class OperationSub extends Operation {

    @Override
    public double getResult() {
        return super.getNumberA() - super.getNumberB();
    }
}
