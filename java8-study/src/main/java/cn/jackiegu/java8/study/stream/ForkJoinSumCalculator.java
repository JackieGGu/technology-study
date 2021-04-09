package cn.jackiegu.java8.study.stream;

import cn.jackiegu.technology.common.util.ArrayUtil;
import cn.jackiegu.technology.common.util.LoggerUtil;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * fork/json 求和测试
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    // 最小阀值
    private static final int THRESHOLD = 100000;

    private final Long[] numbers;

    private final int start;

    private final int end;

    public ForkJoinSumCalculator(Long[] numbers) {
        this(numbers, 0, numbers.length);
        LoggerUtil.info("Common Result");
        long s1 = System.currentTimeMillis();
        Long sum = 0L;
        for (Long number : numbers) {
            sum += number;
        }
        long e1 = System.currentTimeMillis();
        System.out.println("time: " + (e1 - s1));
        System.out.println("sum: " + sum);
    }

    public ForkJoinSumCalculator(Long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            // System.out.println(start + "~" + end + ": " + Thread.currentThread().getName());
            return computeSequentially();
        }
        ForkJoinSumCalculator task1 = new ForkJoinSumCalculator(numbers, start, start + THRESHOLD);
        task1.fork();
        ForkJoinSumCalculator task2 = new ForkJoinSumCalculator(numbers, start + THRESHOLD, end);
        Long task2Result = task2.compute();
        Long task1Result = task1.join();
        return task1Result + task2Result;
    }

    private Long computeSequentially() {
        return Arrays.stream(numbers)
            .skip(start)
            .limit(end - start)
            .reduce(0L, Long::sum);

    }

    public static void main(String[] args) {
        int[] intArr = ArrayUtil.getRandomArray(10000000);
        Long[] longArr = Arrays.stream(intArr).mapToObj(item -> Long.valueOf(String.valueOf(item))).toArray(Long[]::new);
        ForkJoinSumCalculator calculator = new ForkJoinSumCalculator(longArr);
        LoggerUtil.info("Fork/Join Result");
        long s2 = System.currentTimeMillis();
        Long sum = calculator.compute();
        long e2 = System.currentTimeMillis();
        System.out.println("time: " + (e2 - s2));
        System.out.println("sum: " + sum);
    }
}
