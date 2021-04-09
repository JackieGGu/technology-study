package cn.jackiegu.java8.study.optional;

import java.security.SecureRandom;
import java.util.Optional;

/**
 * Optional测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("hello optional");
        System.out.println("optional1: " + optional1);
        Optional<Object> optional2 = Optional.empty();
        System.out.println("optional2: " + optional2);
        String s1 = new SecureRandom().nextInt(2) == 1 ? "true" : null;
        Optional<String> optional3 = Optional.ofNullable(s1);
        System.out.println("optional3: " + optional3);
        System.out.println("optional3 is present: " + optional3.isPresent());
        System.out.println("optional3 value: " + optional3.orElse("false"));
    }
}
