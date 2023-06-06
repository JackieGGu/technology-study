package cn.jackiegu.feature.java8.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * lambda测试类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
@Slf4j
public class LambdaTest {

    @SuppressWarnings("all")
    private String name = "lambda";

    public static void main(String[] args) {
        // 没有参数, 需定义圆括号
        // 主体只有一个语句, 可省略大括号
        PrintHello ph = () -> log.info("hello lambda");
        ph.hello();

        // 一个参数, 可省略圆括号
        // 可省略参数类型声明
        // 主体只有一个表达式语句, 将自动返回该值
        SayHi sh = name -> "hi " + name;
        log.info(sh.hi("lambda"));

        // 多个参数, 需定义圆括号
        Operation oa = (x, y) -> x + y;
        log.info("{}", oa.calculate(3, 2));

        // 主体存在大括号, 需使用关键字声明返回值
        Operation os = (x, y) -> { return x - y; };
        log.info("{}", os.calculate(3, 2));

        // 域外的局部变量具有隐性的final语义
        String name = "lambda";
        ph = () -> {
            // 编译报错
            // name = "lambda1";
            log.info("hello {}", name);
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
            log.info("hello {}", name);
            name = "lambda2";
        };
        name = "lambda3";
        lambdaInterface.run();
    }

    @FunctionalInterface
    interface PrintHello {
        void hello();
    }

    @FunctionalInterface
    interface SayHi {
        String hi(String name);
    }

    @FunctionalInterface
    interface Operation {
        Integer calculate(int x, int y);
    }
}
