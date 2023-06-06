package cn.jackiegu.oop.design.pattern.factory.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 除法运算类
 *
 * @author JackieGu
 */
@Slf4j
public class OperationDiv extends Operation {

    @Override
    public double getResult() {
        double numberA = super.getNumberA();
        double numberB = super.getNumberB();
        if (numberB == 0) {
            log.error("除数B不能为0");
            return 0;
        }
        return numberA / numberB;
    }
}
