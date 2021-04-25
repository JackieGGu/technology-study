package cn.jackiegu.jvm.study.spi;

/**
 * 鸟
 *
 * @author JackieGu
 * @date 2021/4/23
 */
public class Bird implements Animal {

    @Override
    public void move() {
        System.out.println("飞");
    }
}
