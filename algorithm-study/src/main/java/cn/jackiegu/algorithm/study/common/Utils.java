package cn.jackiegu.algorithm.study.common;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 通用工具类
 *
 * @author JackieGu
 * @date 2021/3/30
 */
public class Utils {

    /**
     * 生成随机数组
     */
    public static int[] getRandomArray(int length) {
        return getRandomArray(1000000, length);
    }

    /**
     * 生成随机数组
     */
    public static int[] getRandomArray(int maxValue, int length) {
        int[] arr = new int[length];
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    /**
     * 交换
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 日志打印
     */
    public static void logger(String str) {
        System.out.println("\033[94m" + str + "\033[0m");
    }
}
