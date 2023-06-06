package cn.jackiegu.oop.design.pattern.decorator;

/**
 * 抽象装饰类
 *
 * @author JackieGu
 * @date 2020/9/23
 */
public abstract class AbstractDecorator implements Human {

    /**
     * 被装饰的人类引用
     */
    private final Human human;

    /**
     * 构造函数注入被装饰对象
     */
    protected AbstractDecorator(Human human) {
        this.human = human;
    }

    /**
     * 调用被装饰类的方法
     */
    @Override
    public void run() {
        human.run();
    }
}
