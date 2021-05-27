package cn.jackiegu.design.pattern.study.singleton;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单例模式测试类
 *
 * @author JackieGu
 * @date 2021/5/27
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        LoggerUtil.info("饿汉式测试");
        hungryTest(threadPool);
        LoggerUtil.info("懒汉式一测试");
        lazyTest1(threadPool);
        LoggerUtil.info("懒汉式二测试");
        lazyTest2(threadPool);
        LoggerUtil.info("懒汉式三测试");
        lazyTest3(threadPool);
        threadPool.shutdown();
    }

    public static void hungryTest(ExecutorService threadPool) throws Exception {
        List<Future<HungrySingleton>> futures = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
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
                System.out.println(instance);
                System.out.println(nextInstance);
                isSingleton = false;
                break;
            }
        }
        System.out.println("isSingleton: " + isSingleton);
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
                System.out.println(instance);
                System.out.println(nextInstance);
                isSingleton = false;
                break;
            }
        }
        System.out.println("isSingleton: " + isSingleton);
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
                System.out.println(instance);
                System.out.println(nextInstance);
                isSingleton = false;
                break;
            }
        }
        System.out.println("isSingleton: " + isSingleton);
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
                System.out.println(instance);
                System.out.println(nextInstance);
                isSingleton = false;
                break;
            }
        }
        System.out.println("isSingleton: " + isSingleton);
    }
}
