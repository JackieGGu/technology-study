package cn.jackiegu.program.algorithm.sort;

import cn.jackiegu.program.algorithm.checker.Number;
import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 归并排序
 * <p>
 * 平均时间复杂度: n * log(n)
 * 空间复杂度: 1
 * 稳定性: 稳
 */
@Slf4j
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getRandomArray(10000);
        int time = 100;

        LoggerUtil.info("归并排序");
        long s0 = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sort(arr.clone());
        }
        long e0 = System.currentTimeMillis();
        BigDecimal ms0 = BigDecimal.valueOf(e0 - s0);
        log.info("耗时(ms): {}", ms0);
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int leftPointer, int rightPointer, int rightBound) {
        int[] temp = new int[rightBound - leftPointer + 1];
        int i = 0;
        int j = leftPointer;
        int k = rightPointer + 1;
        while (j <= rightPointer && k <= rightBound) {
            temp[i++] = arr[j] <= arr[k] ? arr[j++] : arr[k++];
        }
        while (j <= rightPointer) {
            temp[i++] = arr[j++];
        }
        while (k <= rightBound) {
            temp[i++] = arr[k++];
        }
        System.arraycopy(temp, 0, arr, leftPointer, temp.length);
    }

    /**
     * 稳定性测试
     */
    public static void stability(Number[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    public static void sort(Number[] numbers, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(numbers, left, mid);
        sort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }

    public static void merge(Number[] number, int leftPointer, int rightPointer, int rightBound) {
        Number[] temp = new Number[rightBound - leftPointer + 1];
        int i = 0;
        int j = leftPointer;
        int k = rightPointer + 1;
        while (j <= rightPointer && k <= rightBound) {
            temp[i++] = number[j].lessAndEquals(number[k]) ? number[j++] : number[k++];
        }
        while (j <= rightPointer) {
            temp[i++] = number[j++];
        }
        while (k <= rightBound) {
            temp[i++] = number[k++];
        }
        System.arraycopy(temp, 0, number, leftPointer, temp.length);
    }
}
