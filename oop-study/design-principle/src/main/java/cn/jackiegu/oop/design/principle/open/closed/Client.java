package cn.jackiegu.oop.design.principle.open.closed;

/**
 * 客户端
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class Client {

    public static void main(String[] args) {
        // Algorithm algorithm = new AddAlgorithm();
        // Calculator calculator = new Calculator(algorithm);
        // int sum = calculator.calculate(3, 2);
        // System.out.println("result: " + sum);

        Algorithm algorithm = new SubtractAlgorithm();
        Calculator calculator = new Calculator(algorithm);
        int sum = calculator.calculate(3, 2);
        System.out.println("result: " + sum);
    }
}
