package cn.jackiegu.oop.design.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 钢铁侠装饰实现类
 *
 * @author JackieGu
 * @date 2020/9/23
 */
@Slf4j
public class IronManDecorator extends AbstractDecorator {

    public IronManDecorator(Human human) {
        super(human);
    }

    @Override
    public void run() {
        super.run();
        this.beam();
    }

    /**
     * 装饰实现类增加的功能
     */
    private void beam() {
        log.info("发射光束");
    }
}
