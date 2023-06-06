package cn.jackiegu.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile关键字测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
@Slf4j
public class VolatileTest {

    /**
     * 因++操作不是原子性的
     * 从而证明volatile关键字修饰的共享变量也不具备原子性
     */
    private volatile int num = 0;

    @SuppressWarnings("all")
    public void add() {
        this.num++;
    }

    /**
     * 解决方式一: 采用synchronized关键字
     */
    private volatile int numSynchronized = 0;
    public synchronized void addBySynchronized() {
        this.numSynchronized++;
    }

    /**
     * 解决方式二: 采用Lock锁
     */
    private volatile int numLock = 0;
    private final Lock lock = new ReentrantLock();
    public synchronized void addByLock() {
        lock.lock();
        try {
            this.numLock++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 解决方式三: 采用具有原子性的AtomicInteger
     */
    private final AtomicInteger atomicNum = new AtomicInteger();
    public void addAtomicInteger() {
        atomicNum.getAndIncrement();
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    test.add();
                    test.addBySynchronized();
                    test.addByLock();
                    test.addAtomicInteger();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            // 让线程由执行状态切换为就绪状态, 让出cpu时间
            Thread.yield();
        }
        log.info("Number: {}", test.num);
        log.info("Number by synchronized: {}", test.numSynchronized);
        log.info("Number by lock: {}", test.numLock);
        log.info("Number By atomic: {}", test.atomicNum.get());
    }
}
