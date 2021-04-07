package cn.jackiegu.algorithm.study.sort;

import cn.jackiegu.algorithm.study.common.Utils;

/**
 * 稳定性测试器
 */
public class StabilityChecker {

    private static final Integer TIME = 10000;

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < TIME; i++) {
            int[] arr = Utils.getRandomArray(1000, 1000);
            Number[] source = new Number[arr.length];
            for (int j = 0; j < source.length; j++) {
                source[j] = new Number(arr[j]);
            }
            Number[] numbers = source.clone();

            // 选择排序
            // SelectionSort.stability(numbers);
            // 冒泡排序
            BubbleSort.stability(numbers);

            if (!stabilityChecker(source, numbers)) {
                result = false;
                break;
            }
        }
        System.out.println("算法稳定性: " + result);
    }

    /**
     * 稳定性检查
     */
    private static boolean stabilityChecker(Number[] sourceArr, Number[] sortArr) {
        for (int i = 0; i < sortArr.length;) {
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
