package cn.jackiegu.oop.design.pattern.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 雷锋类
 *
 * @author JackieGu
 */
@Slf4j
public class LeiFeng {

    public void sweep() {
        log.info("扫地");
    }

    public void wash() {
        log.info("洗衣");
    }

    public void cooking() {
        log.info("做饭");
    }
}
