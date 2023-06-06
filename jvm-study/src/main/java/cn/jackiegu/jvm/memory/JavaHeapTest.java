package cn.jackiegu.jvm.memory;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Java堆测试
 * VM Args: -Xms32m -Xmx32m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author JackieGu
 * @date 2021/5/6
 */
@Slf4j
public class JavaHeapTest {

    private final Integer randomNumber;

    private final String randomString;

    public JavaHeapTest(Integer randomNumber) {
        this.randomNumber = randomNumber;
        this.randomString = String.valueOf(randomNumber);
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Random random = new SecureRandom();
        List<JavaHeapTest> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new JavaHeapTest(random.nextInt(99999)));
            }
        } catch (Error e) {
            log.info("list size: {}", list.size(), e);
        }
    }
}
