package cn.jackiegu.oop.design.pattern.factory.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 算法简单工厂类
 *
 * @author JackieGu
 */
@Slf4j
public class OperationFactory {

    public static Operation getOperation(String operation) {
        switch (operation) {
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSub();
            case "*":
                return new OperationMul();
            case "/":
                return new OperationDiv();
            default:
                log.error("不支持的算法类型");
                return null;
        }
    }
}
