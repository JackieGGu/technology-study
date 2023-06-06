package cn.jackiegu.oop.design.pattern.singleton;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单例模式测试类
 * 单例破坏方式:
 *   1. 反射破坏
 *   2. 序列化破坏
 *
 * @author JackieGu
 * @date 2021/5/27
 */
@Slf4j
public class SingletonTest {

    private static final String SINGLETON = "singleton: {}";

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try {
            LoggerUtil.info("饿汉式测试");
            hungryTest(threadPool);

            LoggerUtil.info("懒汉式一测试");
            lazyTest1(threadPool);
            LoggerUtil.info("懒汉式二测试");
            lazyTest2(threadPool);
            LoggerUtil.info("懒汉式三测试");
            lazyTest3(threadPool);
        } catch (Exception e) {
            log.error("singleton test failure", e);
        } finally {
            threadPool.shutdown();
        }
    }

    public static void hungryTest(ExecutorService threadPool) throws Exception {
        List<Future<HungrySingleton>> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            /*
             * 首次循环, 在调用HungrySingleton.getInstance()方法之前
             * 类加载器会先对HungrySingleton类进行加载, 并完成静态变量的初始化
             * 所以在getInstance()方法执行之前单例实例就已被创建好了
             */
            futures.add(threadPool.submit(HungrySingleton::getInstance));
        }
        boolean isSingleton = true;
        HungrySingleton instance = null;
        for (Future<HungrySingleton> future : futures) {
            if (instance == null) {
                instance = future.get();
                continue;
            }
            HungrySingleton nextInstance = future.get();
            if (instance != nextInstance) {
                log.info(instance.toString());
                log.info(nextInstance.toString());
                isSingleton = false;
                break;
            }
        }
        log.info(SINGLETON, isSingleton);
    }

    public static void lazyTest1(ExecutorService threadPool) throws Exception {
        List<Future<LazySingleton1>> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            futures.add(threadPool.submit(LazySingleton1::getInstance));
        }
        boolean isSingleton = true;
        LazySingleton1 instance = null;
        for (Future<LazySingleton1> future : futures) {
            if (instance == null) {
                instance = future.get();
                continue;
            }
            LazySingleton1 nextInstance = future.get();
            if (instance != nextInstance) {
                log.info(instance.toString());
                log.info(nextInstance.toString());
                isSingleton = false;
                break;
            }
        }
        log.info(SINGLETON, isSingleton);
    }

    public static void lazyTest2(ExecutorService threadPool) throws Exception {
        List<Future<LazySingleton2>> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            futures.add(threadPool.submit(LazySingleton2::getInstance));
        }
        boolean isSingleton = true;
        LazySingleton2 instance = null;
        for (Future<LazySingleton2> future : futures) {
            if (instance == null) {
                instance = future.get();
                continue;
            }
            LazySingleton2 nextInstance = future.get();
            if (instance != nextInstance) {
                log.info(instance.toString());
                log.info(nextInstance.toString());
                isSingleton = false;
                break;
            }
        }
        log.info(SINGLETON, isSingleton);
    }

    public static void lazyTest3(ExecutorService threadPool) throws Exception {
        List<Future<LazySingleton3>> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            futures.add(threadPool.submit(LazySingleton3::getInstance));
        }
        boolean isSingleton = true;
        LazySingleton3 instance = null;
        for (Future<LazySingleton3> future : futures) {
            if (instance == null) {
                instance = future.get();
                continue;
            }
            LazySingleton3 nextInstance = future.get();
            if (instance != nextInstance) {
                log.info(instance.toString());
                log.info(nextInstance.toString());
                isSingleton = false;
                break;
            }
        }
        log.info(SINGLETON, isSingleton);
    }
}
