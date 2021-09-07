package cn.jackiegu.cache.study.caffeine;

import cn.jackiegu.technology.common.util.LoggerUtil;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Caffeine缓存测试
 *
 * @author JackieGu
 * @date 2021/9/7
 */
public class CaffeineTest {

    public static void main(String[] args) {
        // 手动填充
        manualPopulation();
        // 同步缓存
        syncCache();
        // 异步缓存
        asyncCache();
    }

    /**
     * 手动填充
     */
    public static void manualPopulation() {
        LoggerUtil.info("========== manual population ==========");
        Cache<Object, Object> cache = Caffeine.newBuilder()
            .maximumSize(2)
            // 当写入后经过多长时间无效
            .expireAfterWrite(30, TimeUnit.SECONDS)
            .build();

        LoggerUtil.info("get user: ");
        // 当key不存在时返回null
        Object userValue = cache.getIfPresent("user");
        System.out.println(userValue);

        // 当key不存在时执行函数式接口, 并将返回值注入缓存中
        userValue = cache.get("user", key -> new User(key.toString(), 0));
        System.out.println(userValue);

        LoggerUtil.info("put user: ");
        User zs = new User("张三", 24);
        cache.put("user", zs);
        // 当key存在时不会执行函数式接口
        userValue = cache.get("user", key -> new User(key.toString(), 1));
        System.out.println(userValue);

        User ls = new User("李四", 26);
        cache.put("user", ls);
        // 当key存在时直接返回缓存值
        userValue = cache.getIfPresent("user");
        System.out.println(userValue);

        LoggerUtil.info("as map: ");
        // 驱逐数据
        cache.invalidate("user");
        // 将缓存转换map
        ConcurrentMap<@NonNull Object, @NonNull Object> cacheMap = cache.asMap();
        System.out.println(cacheMap);

        cache.put("a", "123");
        cache.put("b", "456");
        cache.put("c", "789");
        // Caffeine采用的惰性驱逐策略, 数据被淘汰后不会立即被驱逐, 可能是发生在下一次读/写/cleanUp函数被调用的时候才会被驱逐
        cache.cleanUp();
        cacheMap = cache.asMap();
        System.out.println(cacheMap);
    }

    /**
     * 同步缓存
     */
    public static void syncCache() {
        LoggerUtil.info("========== sync population ==========");
        LoadingCache<String, User> cache = Caffeine.newBuilder()
            .maximumSize(2)
            // 当写入或者访问后经过多长时间无效
            .expireAfterAccess(30, TimeUnit.SECONDS)
            .build((String key) -> {
                // 同步将使用主线程
                System.out.println(LoggerUtil.threadName());
                return new User(key, 0);
            });

        LoggerUtil.info("get user: ");
        // 当key不存在时不会执行CacheLoader函数式接口
        User userValue = cache.getIfPresent("user");
        System.out.println(userValue);

        // 当key不存在时会执行CacheLoader函数式接口, 并将返回值注入缓存中
        userValue = cache.get("user");
        System.out.println(userValue);

        User zs = new User("张三", 24);
        cache.put("zs", zs);;
        // 当key存在时不会执行CacheLoader函数式接口
        userValue = cache.get("zs");
        System.out.println(userValue);
    }

    /**
     * 异步缓存
     */
    public static void asyncCache() {
        LoggerUtil.info("========== async population ==========");
        AsyncLoadingCache<String, User> cache = Caffeine.newBuilder()
            .maximumSize(2)
            .expireAfterAccess(30, TimeUnit.SECONDS)
            .buildAsync((String key) -> {
                // 异步将使用线程池线程
                System.out.println(LoggerUtil.threadName());
                // 随机进行睡眠
                Random random = new SecureRandom();
                int number = random.nextInt(2);
                if (number == 1) {
                    Thread.sleep(200);
                }
                return new User(key, 0);
            });

        LoggerUtil.info("get user: ");
        // 当key不存在时将返回null
        CompletableFuture<User> userFuture = cache.getIfPresent("user");
        System.out.println(userFuture);

        // 当key不存在时会执行CacheLoader函数式接口, 并将返回值注入缓存中
        userFuture = cache.get("user");
        if (userFuture.isDone()) {
            try {
                System.out.println("user: " + userFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("done: false");
        }

        LoggerUtil.info("transform sync cache: ");
        // 转为同步缓存
        LoadingCache<String, User> syncCache = cache.synchronous();
        User user = syncCache.get("user");
        System.out.println(user);
        User zs = syncCache.get("zs");
        System.out.println(zs);
    }

    private static class User {

        private String name;

        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "{" +
                "name=" + name +
                ", age=" + age +
                "}";
        }
    }
}
