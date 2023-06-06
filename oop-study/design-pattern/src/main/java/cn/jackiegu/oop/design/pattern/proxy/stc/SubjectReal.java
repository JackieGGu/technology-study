package cn.jackiegu.oop.design.pattern.proxy.stc;

import lombok.extern.slf4j.Slf4j;

/**
 * 实际对象类
 *
 * @author JackieGu
 * @date 2020/9/24
 */
@Slf4j
public class SubjectReal implements Subject {

    @Override
    public void request() {
        log.info("do something...");
    }
}
