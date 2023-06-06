package cn.jackiegu.jvm.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * 程序计数器测试
 *
 * @author JackieGu
 * @date 2021/4/30
 */
public class ProgramCounterRegisterTest {

    public static void main(String[] args) {
        Thread thread0 = new Thread(new R0());
        Thread thread1 = new Thread(new R1());
        thread0.start();
        thread1.start();
    }
}

@Slf4j
class R0 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info("thread0: {}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

@Slf4j
class R1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info("thread1: {}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}