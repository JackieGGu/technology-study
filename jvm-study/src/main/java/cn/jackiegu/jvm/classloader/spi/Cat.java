package cn.jackiegu.jvm.classloader.spi;

import lombok.extern.slf4j.Slf4j;

/**
 * 猫咪
 *
 * @author JackieGu
 * @date 2021/4/23
 */
@Slf4j
public class Cat implements Animal {

    @Override
    public void move() {
        log.info("小猫跑");
    }
}
