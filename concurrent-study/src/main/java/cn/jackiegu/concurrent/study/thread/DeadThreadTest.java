package cn.jackiegu.concurrent.study.thread;

import cn.jackiegu.technology.common.util.LoggerUtil;

/**
 * 死锁线程测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class DeadThreadTest {

    private static final Object o1 = new Object();

    private static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println(LoggerUtil.threadName() + " get object1");
                    Thread.sleep(3000);
                    System.out.println(LoggerUtil.threadName() + " wait object2");
                    synchronized (o2) {
                        System.out.println(LoggerUtil.threadName() + " get object2");
                    }
                } catch (InterruptedException ignored) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    System.out.println(LoggerUtil.threadName() + " get object2");
                    Thread.sleep(3000);
                    System.out.println(LoggerUtil.threadName() + " wait object1");
                    synchronized (o1) {
                        System.out.println(LoggerUtil.threadName() + " get object1");
                    }
                } catch (InterruptedException ignored) {

                }
            }
        }).start();
    }
}
