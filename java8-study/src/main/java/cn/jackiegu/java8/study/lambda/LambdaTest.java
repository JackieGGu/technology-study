package cn.jackiegu.java8.study.lambda;

/**
 * lambda测试类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
public class LambdaTest {

    private String name = "lambda";

    public static void main(String[] args) {
        // 没有参数, 需定义圆括号
        // 主体只有一个语句, 可省略大括号
        PrintHello ph = () -> System.out.println("hello lambda");
        ph.hello();

        // 一个参数, 可省略圆括号
        // 可省略参数类型声明
        // 主体只有一个表达式语句, 将自动返回该值
        SayHi sh = name -> "hi " + name;
        System.out.println(sh.hi("lambda"));

        // 多个参数, 需定义圆括号
        Operation oa = (x, y) -> x + y;
        System.out.println(oa.calculate(3, 2));

        // 主体存在大括号, 需使用关键字声明返回值
        Operation os = (x, y) -> { return x - y; };
        System.out.println(os.calculate(3, 2));

        // 域外的局部变量具有隐性的final语义
        String name = "lambda";
        ph = () -> {
            // 编译报错
            // name = "lambda1";
            System.out.println("hello " + name);
        };
        // 编译报错
        // name = "lambda2";
        ph.hello();

        // 域外的成员变量具有隐性的final语义
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.doPrint();
    }

    public void doPrint() {
        LambdaInterface lambdaInterface = () -> {
            name = "lambda1";
            System.out.println("hello " + name);
            name = "lambda2";
        };
        name = "lambda3";
        lambdaInterface.run();
    }

    interface PrintHello {
        void hello();
    }

    interface SayHi {
        String hi(String name);
    }

    interface Operation {
        Integer calculate(int x, int y);
    }
}
