package cn.jackiegu.program.algorithm.checker;

import cn.jackiegu.program.algorithm.sort.MergeSort;
import cn.jackiegu.technology.common.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 稳定性测试器
 */
@Slf4j
public class StabilityChecker {

    private static final Integer TIME = 10000;

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < TIME; i++) {
            int[] arr = ArrayUtil.getRandomArray(1000, 1000);
            Number[] source = new Number[arr.length];
            for (int j = 0; j < source.length; j++) {
                source[j] = new Number(arr[j]);
            }
            Number[] numbers = source.clone();

            // 选择排序
            // SelectionSort.stability(numbers);

            // 冒泡排序
            // BubbleSort.stability(numbers);

            // 插入排序
            // InsertionSort.stability(numbers);

            // 希尔排序
            // ShellSort.stability(numbers);

            // 归并排序
            MergeSort.stability(numbers);

            if (!stabilityChecker(source, numbers)) {
                result = false;
                break;
            }
        }
        log.info("算法稳定性: {}", result);
    }

    /**
     * 稳定性检查
     */
    private static boolean stabilityChecker(Number[] sourceArr, Number[] sortArr) {
        for (int i = 0; i < sortArr.length; ) {
            Number n = sortArr[i];
            int j = i + 1;
            for (; j < sortArr.length; j++) {
                if (!sortArr[j].equals(n)) {
                    break;
                }
            }
            if (j == i + 1) {
                i = j;
                continue;
            }
            int k = i;
            for (Number number : sourceArr) {
                if (number.equals(n)) {
                    if (number != sortArr[k]) {
                        return false;
                    }
                    k++;
                }
            }
            i = j;
        }
        return true;
    }
}
