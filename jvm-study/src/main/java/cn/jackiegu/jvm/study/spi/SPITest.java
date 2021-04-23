package cn.jackiegu.jvm.study.spi;

import java.util.ServiceLoader;

/**
 * 测试类
 *
 * @author JackieGu
 * @date 2021/4/23
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.reproduce();
        }
    }
}
