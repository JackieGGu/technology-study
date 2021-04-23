package cn.jackiegu.jvm.study.spi;

/**
 * 猫咪
 *
 * @author JackieGu
 * @date 2021/4/23
 */
public class Cat implements Animal {

    @Override
    public void reproduce() {
        System.out.println("生育");
    }
}
