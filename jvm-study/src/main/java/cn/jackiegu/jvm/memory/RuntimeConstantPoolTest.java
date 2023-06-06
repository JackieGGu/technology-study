package cn.jackiegu.jvm.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * 运行时常量池测试
 * 可通过 javap -verbose *.class 命令查看class文件的常量池
 *
 * @author JackieGu
 * @date 2021/5/7
 */
@Slf4j
public class RuntimeConstantPoolTest {

    public void add() {
        minus();
    }

    private void minus() {
        log.info("minus");
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        String s = "hello";
        log.info("s = {}", s);

        /*
         * "计算机软件"一词由于是第一次出现, 因此intern()返回的引用和由StringBuilder创建的字符串实例就是同一个
         *  所以结果为true
         */
        String s1 = new StringBuilder("计算机").append("软件").toString();
        log.info("s1: {}", s1.intern() == s1);

        /*
         * "java"一词由于不是第一次出现, 早在sun.misc.Version这个类的时候就已进入了常量池中, 因此intern()返回的引用和由StringBuilder创建的字符串实例不是同一个
         *  所以结果为false
         */
        String s2 = new StringBuilder("ja").append("va").toString();
        log.info("s2: {}", s2.intern() == s2);
    }
}
