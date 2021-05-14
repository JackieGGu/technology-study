package cn.jackiegu.design.principle.study.open.closed;

/**
 * 减法算法
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class SubtractAlgorithm implements Algorithm {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
