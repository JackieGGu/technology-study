package cn.jackiegu.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程死锁测试
 *
 * @author JackieGu
 * @date 2021/4/9
 */
@Slf4j
public class ThreadDeadLockTest {

    private static final Object o1 = new Object();

    private static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                try {
                    log.info("Get object1");
                    o1.wait(3000);
                    log.info("Wait object2");
                    synchronized (o2) {
                        log.info("Get object2");
                    }
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    log.info("Get object2");
                    o2.wait(3000);
                    log.info("Wait object1");
                    synchronized (o1) {
                        log.info("Get object1");
                    }
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
