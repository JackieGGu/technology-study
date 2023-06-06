package cn.jackiegu.program.algorithm.checker;

import cn.jackiegu.program.algorithm.sort.MergeSort;
import cn.jackiegu.technology.common.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 对数器
 */
@Slf4j
public class DataChecker {

    private static final Integer TIME = 10000;

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < TIME; i++) {
            int[] source = ArrayUtil.getRandomArray(1000, 1000);
            int[] arr = source.clone();
            Arrays.sort(source);

            // 选择排序
            // SelectionSort.sort0(arr);
            // SelectionSort.sort1(arr);
            // SelectionSort.sort2(arr);

            // 冒泡排序
            // BubbleSort.sort0(arr);
            // BubbleSort.sort1(arr);

            // 插入排序
            // InsertionSort.sort0(arr);

            // 希尔排序
            // ShellSort.sort0(arr);
            // ShellSort.sort1(arr);

            // 归并排序
            MergeSort.sort(arr);

            if (!Arrays.equals(source, arr)) {
                result = false;
                break;
            }
        }
        log.info("算法正确性: {}", result);
    }
}
