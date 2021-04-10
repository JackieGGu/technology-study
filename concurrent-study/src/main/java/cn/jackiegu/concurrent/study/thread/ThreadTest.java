package cn.jackiegu.concurrent.study.thread;

import cn.jackiegu.technology.common.util.LoggerUtil;

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

}

class T1 extends Thread {

    @Override
    public void run() {
        System.out.println("i am t1");
    }
}

class T2 extends Thread {

    Thread t1;

    public T2(Thread t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        try {
            t1.join();
        } catch (InterruptedException ignored) {

        }
        System.out.println("i am t2");
    }
}