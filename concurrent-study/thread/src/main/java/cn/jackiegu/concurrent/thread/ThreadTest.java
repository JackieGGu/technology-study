package cn.jackiegu.concurrent.thread;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 线程测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class ThreadTest {

    public static void main(String[] args) {
        // 线程之顺序执行
        LoggerUtil.info("线程之顺序执行");
        Thread t1 = new T1();
        Thread t2 = new T2(t1);
        t2.start();
        t1.start();
    }

    @Slf4j
    static class T1 extends Thread {

        @Override
        public void run() {
            log.info("i am t1");
        }
    }

    @Slf4j
    static class T2 extends Thread {

        Thread t1;

        public T2(Thread t1) {
            this.t1 = t1;
        }

        @Override
        public void run() {
            try {
                // 表示当前线程让出CPU时间片, 让t1线程加入进来进行执行, 并且在t1线程执行完成后再执行当前线程
                t1.join();
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
            log.info("i am t2");
        }
    }

}