package cn.jackiegu.program.algorithm.sort;

import cn.jackiegu.program.algorithm.checker.Number;
import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 希尔排序
 * <p>
 * 平均时间复杂度: n^1.3
 * 空间复杂度: 1
 * 稳定性: 不稳
 */
@Slf4j
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArray(10000);
        int time = 100;

        LoggerUtil.info("希尔排序(Shell方式)");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort0(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        log.info("耗时(ms): {}", ms0);

        LoggerUtil.info("希尔排序(Knuth方式)");
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
        for (int h = arr.length >> 1; h > 0; h = h >> 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        ArrayUtil.swap(arr, j, j - h);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = 3 * h + 1;
        }
        for (; h > 0; h = (h - 1) / 3) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        ArrayUtil.swap(arr, j, j - h);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 稳定性测试
     */
    public static void stability(Number[] numbers) {
        int h = 1;
        while (h < numbers.length / 3) {
            h = 3 * h + 1;
        }
        for (; h > 0; h = (h - 1) / 3) {
            for (int i = h; i < numbers.length; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (numbers[j].less(numbers[j - h])) {
                        Number temp = numbers[j];
                        numbers[j] = numbers[j - h];
                        numbers[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
