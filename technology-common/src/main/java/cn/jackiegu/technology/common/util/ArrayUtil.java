package cn.jackiegu.technology.common.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 数组工具类
 *
 * @author JackieGu
 * @date 2021/4/7
 */
public class ArrayUtil {

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
}
