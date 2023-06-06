package cn.jackiegu.oop.design.principle.open.closed;

/**
 * 加法算法
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class AddAlgorithm implements Algorithm {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
