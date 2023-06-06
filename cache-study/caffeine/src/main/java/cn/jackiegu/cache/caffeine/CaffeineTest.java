package cn.jackiegu.cache.caffeine;

import cn.jackiegu.technology.common.util.LoggerUtil;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        LoggerUtil.info("========== 手动填充 ==========");
        Cache<Object, Object> cache = Caffeine.newBuilder()
            .maximumSize(2)
            // 当写入后经过多长时间无效
            .expireAfterWrite(30, TimeUnit.SECONDS)
            .build();

        LoggerUtil.info("获取缓存测试");
        // 当key不存在时返回null
        Object user1 = cache.getIfPresent("user1");
        log.info("user1: {}", user1);
        // 当key不存在时执行函数式接口, 并将返回值注入缓存中
        Object user2 = cache.get("user2", key -> new User(key.toString(), 0));
        log.info("user2: {}", user2);

        LoggerUtil.info("存储缓存测试");
        User zs = new User("张三", 24);
        cache.put("user3", zs);
        // 当key存在时不会执行函数式接口
        Object user3 = cache.get("user3", key -> new User(key.toString(), 1));
        log.info("user3: {}", user3);
        User ls = new User("李四", 26);
        cache.put("user4", ls);
        // 当key存在时直接返回缓存值
        Object user4 = cache.getIfPresent("user4");
        log.info("user4: {}", user4);

        LoggerUtil.info("转换键值对测试");
        // 驱逐数据
        cache.invalidateAll();
        // 将缓存转换map
        ConcurrentMap<@NonNull Object, @NonNull Object> map1 = cache.asMap();
        log.info("map1: {}", map1);

        cache.put("a", "123");
        cache.put("b", "456");
        cache.put("c", "789");
        // Caffeine采用的惰性驱逐策略, 数据被淘汰后不会立即被驱逐, 可能是发生在下一次读/写/cleanUp函数被调用的时候才会被驱逐
        cache.cleanUp();
        ConcurrentMap<@NonNull Object, @NonNull Object> map2 = cache.asMap();
        log.info("map2: {}", map2);
    }

    /**
     * 同步缓存
     */
    public static void syncCache() {
        LoggerUtil.info("========== 同步缓存 ==========");
        LoadingCache<String, User> cache = Caffeine.newBuilder()
            .maximumSize(2)
            // 当写入或者访问后经过多长时间无效
            .expireAfterAccess(30, TimeUnit.SECONDS)
            .build((String key) -> {
                // 同步将使用主线程
                log.info(LoggerUtil.threadName());
                return new User(key, 0);
            });

        LoggerUtil.info("获取缓存测试");
        // 当key不存在时不会执行CacheLoader函数式接口
        User user1 = cache.getIfPresent("user1");
        log.info("user1: {}", user1);

        // 当key不存在时会执行CacheLoader函数式接口, 并将返回值注入缓存中
        User user2 = cache.get("user2");
        log.info("user2: {}", user2);

        User zs = new User("张三", 24);
        cache.put("user3", zs);
        // 当key存在时不会执行CacheLoader函数式接口
        User user3 = cache.get("user3");
        log.info("user3: {}", user3);
    }

    /**
     * 异步缓存
     */
    public static void asyncCache() {
        LoggerUtil.info("========== 异步缓存 ==========");
        AsyncLoadingCache<String, User> cache = Caffeine.newBuilder()
            .maximumSize(2)
            .expireAfterAccess(30, TimeUnit.SECONDS)
            .buildAsync((String key) -> {
                // 异步将使用线程池线程
                log.info(LoggerUtil.threadName());
                // 随机进行睡眠
                Random random = new SecureRandom();
                int number = random.nextInt(2);
                if (number == 1) {
                    Thread.sleep(200);
                }
                return new User(key, number);
            });

        LoggerUtil.info("获取缓存测试");
        // 当key不存在时将返回null
        CompletableFuture<User> user1 = cache.getIfPresent("user1");
        log.info("user1: {}", user1);

        // 当key不存在时会执行CacheLoader函数式接口, 并将返回值注入缓存中
        CompletableFuture<User> user2 = cache.get("user2");
        if (user2.isDone()) {
            try {
                log.info("user2: {}", user2.get());
            } catch (Exception e) {
                log.error("Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        } else {
            log.warn("the user2 is not create done");
        }

        LoggerUtil.info("Transform Sync Cache");
        // 转为同步缓存
        LoadingCache<String, User> syncCache = cache.synchronous();
        User syncUser1 = syncCache.get("user1");
        log.info("syncUser1: {}", syncUser1);
        User syncUser2 = syncCache.get("user1");
        log.info("syncUser2: {}", syncUser2);
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
