package cn.jackiegu.jvm.study.memory;

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

class R0 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread0: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class R1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}