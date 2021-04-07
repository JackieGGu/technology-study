package cn.jackiegu.algorithm.study.sort;

import cn.jackiegu.technology.common.util.ArrayUtil;

import java.util.Arrays;

/**
 * 对数器
 */
public class DataChecker {

    private static final Integer TIME = 10000;

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < TIME; i++) {
            int[] source = ArrayUtil.getRandomArray(1000, 1000);
            int[] arr = source.clone();
            Arrays.sort(source);

            // 选择算法
            // SelectionSort.sort0(arr);
            // SelectionSort.sort1(arr);
            // SelectionSort.sort2(arr);

            // 冒泡算法
            // BubbleSort.sort0(arr);
            BubbleSort.sort1(arr);

            if (!Arrays.equals(source, arr)) {
                result = false;
                break;
            }
        }
        System.out.println("算法正确性: " + result);
    }
}
