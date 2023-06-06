package cn.jackiegu.program.algorithm.sort;

import cn.jackiegu.program.algorithm.checker.Number;
import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 插入排序
 * <p>
 * 平均时间复杂度: n^2
 * 空间复杂度: 1
 * 稳定性: 稳
 */
@Slf4j
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArray(10000);
        int time = 100;

        LoggerUtil.info("插入排序");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort0(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        log.info("耗时(ms): {}", ms0);
    }

    public static void sort0(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 稳定性测试
     */
    public static void stability(Number[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j].less(numbers[j - 1])) {
                    Number temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
