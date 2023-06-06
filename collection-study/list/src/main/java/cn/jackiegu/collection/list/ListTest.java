package cn.jackiegu.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合测试
 *
 * @author JackieGu
 * @date 2022/5/9
 */
@Slf4j
public class ListTest {

    public static void main(String[] args) {
        ListTest.arrayListScaleTest();
    }

    /**
     * ArrayList扩容
     */
    private static void arrayListScaleTest() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Object());
        }
        log.info("list size: {}", list.size());
    }
}
