package cn.jackiegu.jvm.study.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区测试
 *
 * @author JackieGu
 * @date 2021/5/6
 */
public class MethodAreaTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(("hello method area " + i++).intern());
        }
    }
}
