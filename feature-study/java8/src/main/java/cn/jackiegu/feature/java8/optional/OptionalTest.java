package cn.jackiegu.feature.java8.optional;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.Optional;

/**
 * Optional测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
@Slf4j
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("hello optional");
        log.info("optional1: {}", optional1);
        Optional<Object> optional2 = Optional.empty();
        log.info("optional2: {}", optional2);
        String s1 = new SecureRandom().nextInt(2) == 1 ? "true" : null;
        Optional<String> optional3 = Optional.ofNullable(s1);
        log.info("optional3: {}", optional3);
        log.info("optional3 is present: {}", optional3.isPresent());
        log.info("optional3 value: {}", optional3.orElse("false"));
    }
}
