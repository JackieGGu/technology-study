package cn.jackiegu.program.algorithm.sort;

import cn.jackiegu.program.algorithm.checker.Number;
import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 冒泡排序
 * <p>
 * 平均时间复杂度: n^2
 * 空间复杂度: 1
 * 稳定性: 稳
 */
@Slf4j
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArray(10000);
        int time = 100;

        LoggerUtil.info("冒泡排序");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort0(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        log.info("耗时(ms): {}", ms0);

        LoggerUtil.info("冒泡排序(升级方案一)");
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort1(arr.clone());
        }
        long e1 = System.currentTimeMillis();
        BigDecimal ms1 = BigDecimal.valueOf(e1 - s1);
        log.info("耗时(ms): {}", ms1);
        BigDecimal t1 = ms0.subtract(ms1).divide(ms1, 2, RoundingMode.HALF_UP);
        log.info("效率提高: {}", t1);
    }

    public static void sort0(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 稳定性测试
     */
    public static void stability(Number[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j].more(numbers[j + 1])) {
                    Number temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
