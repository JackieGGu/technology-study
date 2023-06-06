package cn.jackiegu.oop.design.principle.open.closed;

/**
 * 计算器
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class Calculator {

    private final Algorithm algorithm;

    public Calculator(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * 计算
     */
    public int calculate(int a, int b) {
        return algorithm.calculate(a, b);
    }
}
