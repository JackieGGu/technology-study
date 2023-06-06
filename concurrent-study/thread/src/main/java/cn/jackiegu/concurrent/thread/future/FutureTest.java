package cn.jackiegu.concurrent.thread.future;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Future测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
@Slf4j
public class FutureTest {

    public static void main(String[] args) throws Exception {
        FutureTest.doFutureTask();
        FutureTest.doCalculateTask();
    }

    public static void doFutureTask() throws Exception {
        LoggerUtil.info("自创线程任务");
        RunnableFuture<Integer> task1 = new FutureTask<>(() -> {
            log.info("task1 is running");
            Thread.sleep(10000);
            return new SecureRandom().nextInt(100);
        });
        new Thread(task1).start();
        log.info("task1 is done: {}", task1.isDone());
        log.info("task1 result: {}", task1.get());
    }

    public static void doCalculateTask() throws Exception {
        LoggerUtil.info("单线程池计算任务");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        CalculateTask singleThreadCalculateTask = new CalculateTask(singleThreadExecutor);
        // 单个任务
        Future<Integer> task1 = singleThreadCalculateTask.calculate(5);
        while (!task1.isDone()) {
            log.info("task1 is running");
            Thread.sleep(1000);
        }
        log.info("task1 result: {}", task1.get());
        // 多个任务并发
        Future<Integer> task2 = singleThreadCalculateTask.calculate(6);
        Future<Integer> task3 = singleThreadCalculateTask.calculate(7);
        while (!task2.isDone() || !task3.isDone()) {
            boolean f2 = task2.isDone();
            boolean f3 = task3.isDone();
            log.info("{}{}is running", f2 ? "" : "task2 ", f3 ? "" : "task3 ");
            Thread.sleep(1000);
        }
        log.info("task2 result: {}", task2.get());
        log.info("task3 result: {}", task3.get());
        // 线程池关闭
        singleThreadCalculateTask.destroy();

        LoggerUtil.info("多线程池计算任务");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        CalculateTask fixedThreadCalculateTask = new CalculateTask(fixedThreadPool);
        Future<Integer> task4 = fixedThreadCalculateTask.calculate(8);
        Future<Integer> task5 = fixedThreadCalculateTask.calculate(9);
        while (!task4.isDone() || !task5.isDone()) {
            boolean f4 = task4.isDone();
            boolean f5 = task5.isDone();
            log.info("{}{}is running", f4 ? "" : "task4 ", f5 ? "" : "task5 ");
            Thread.sleep(1000);
        }
        log.info("task4 result: {}", task4.get());
        log.info("task5 result: {}", task5.get());
        // 线程池关闭
        fixedThreadCalculateTask.destroy();
    }
}
