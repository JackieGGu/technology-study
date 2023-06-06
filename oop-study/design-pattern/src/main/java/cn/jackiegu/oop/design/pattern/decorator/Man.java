package cn.jackiegu.oop.design.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 人类实现类
 *
 * @author JackieGu
 * @date 2020/9/22
 */
@Slf4j
public class Man implements Human {

    @Override
    public void run() {
        log.info("学习技能");
    }
}
