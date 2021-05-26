package cn.jackiegu.algorithm.study.sort;

import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;

import java.math.BigDecimal;

/**
 * 归并排序
 * <p>
 * 平均时间复杂度:
 * 空间复杂度:
 * 稳定性: 稳
 */
public class MergeSort {

    public static void main(String[] args) {
        // int[] arr = ArrayUtil.getRandomArray(10000);
        int[] arr = {1, 4, 7, 9, 2, 5, 8};
        int time = 1;

        LoggerUtil.info("普通方式");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        System.out.println("耗时(ms): " + ms0);
    }

    public static void sort(int[] arr) {

    }

    public static void merge(int arr) {

    }

}
