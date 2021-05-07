package cn.jackiegu.jvm.study.memory;

/**
 * 运行时常量池测试
 * 可通过 javap -verbose *.class 命令查看class文件的常量池
 *
 * @author JackieGu
 * @date 2021/5/7
 */
public class RuntimeConstantPoolTest {

    public void add() {
        minus();
    }

    private void minus() {

    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println("s = " + s);
    }
}
