package cn.jackiegu.oop.design.pattern.proxy.stc;

import lombok.extern.slf4j.Slf4j;

/**
 * 代理对象类
 *
 * @author JackieGu
 * @date 2020/9/24
 */
@Slf4j
public class SubjectProxy implements Subject {

    private final SubjectReal object;

    public SubjectProxy(SubjectReal object) {
        this.object = object;
    }

    @Override
    public void request() {
        this.before();
        object.request();
        this.after();
    }

    /**
     * 代理对象方法扩展
     */
    private void before() {
        log.info("before...");
    }

    /**
     * 代理对象方法扩展
     */
    private void after() {
        log.info("after...");
    }
}
