package cn.jackiegu.jvm.classloader.spi;

import lombok.extern.slf4j.Slf4j;

/**
 * 鸟
 *
 * @author JackieGu
 * @date 2021/4/23
 */
@Slf4j
public class Bird implements Animal {

    @Override
    public void move() {
        log.info("小鸟飞");
    }
}
