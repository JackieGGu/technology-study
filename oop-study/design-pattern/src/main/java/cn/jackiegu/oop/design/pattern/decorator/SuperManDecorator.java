package cn.jackiegu.oop.design.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 超人装饰实现类
 *
 * @author JackieGu
 * @date 2020/9/23
 */
@Slf4j
public class SuperManDecorator extends AbstractDecorator {

    public SuperManDecorator(Human human) {
        // 调用装饰类的构造方法
        super(human);
    }

    @Override
    public void run() {
        super.run();
        this.fly();
    }

    /**
     * 装饰实现类增加的功能
     */
    private void fly() {
        log.info("飞");
    }
}
