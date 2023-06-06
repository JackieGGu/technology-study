package cn.jackiegu.program.algorithm.sort;

import cn.jackiegu.program.algorithm.checker.Number;
import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 选择排序
 * <p>
 * 平均时间复杂度: n^2
 * 空间复杂度: 1
 * 稳定性: 不稳
 */
@Slf4j
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArray(10000);
        int time = 100;

        LoggerUtil.info("选择排序");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort0(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        log.info("耗时(ms): {}", ms0);

        LoggerUtil.info("选择排序(升级方案一)");
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort1(arr.clone());
        }
        long e1 = System.currentTimeMillis();
        BigDecimal ms1 = BigDecimal.valueOf(e1 - s1);
        log.info("耗时(ms): {}", ms1);
        BigDecimal t1 = ms0.subtract(ms1).divide(ms1, 2, RoundingMode.HALF_UP);
        log.info("效率提高: {}", t1);

        LoggerUtil.info("选择排序(升级方案二)");
        long s2 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort2(arr.clone());
        }
        long e2 = System.currentTimeMillis();
        BigDecimal ms2 = BigDecimal.valueOf(e2 - s2);
        log.info("耗时(ms): {}", ms2);
        BigDecimal t2 = ms0.subtract(ms2).divide(ms2, 2, RoundingMode.HALF_UP);
        log.info("效率提高: {}", t2);
    }

    public static void sort0(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            ArrayUtil.swap(arr, i, minPos);
        }
    }

    public static void sort1(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int minPos = i;
            int maxPos = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
                maxPos = arr[j] > arr[maxPos] ? j : maxPos;
            }
            ArrayUtil.swap(arr, i, minPos);
            maxPos = maxPos == i ? minPos : maxPos;
            ArrayUtil.swap(arr, arr.length - 1 - i, maxPos);
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int minPos = i;
            int maxPos = i;
            for (int j = i + 1; j < arr.length - i; j += 2) {
                if (j == arr.length - 1 - i) {
                    minPos = arr[j] < arr[minPos] ? j : minPos;
                    maxPos = arr[j] > arr[maxPos] ? j : maxPos;
                    continue;
                }
                if (arr[j] < arr[j + 1]) {
                    minPos = arr[j] < arr[minPos] ? j : minPos;
                    maxPos = arr[j + 1] > arr[maxPos] ? j + 1 : maxPos;
                } else {
                    minPos = arr[j + 1] < arr[minPos] ? j + 1 : minPos;
                    maxPos = arr[j] > arr[maxPos] ? j : maxPos;
                }
            }
            ArrayUtil.swap(arr, i, minPos);
            maxPos = maxPos == i ? minPos : maxPos;
            ArrayUtil.swap(arr, arr.length - 1 - i, maxPos);
        }
    }

    /**
     * 稳定性测试
     */
    public static void stability(Number[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < numbers.length; j++) {
                minPos = numbers[j].less(numbers[minPos]) ? j : minPos;
            }
            Number temp = numbers[i];
            numbers[i] = numbers[minPos];
            numbers[minPos] = temp;
        }
    }
}
