package cn.jackiegu.concurrent.thread.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 计算任务
 *
 * @author JackieGu
 * @date 2021/4/9
 */
@Slf4j
public class CalculateTask {

    private final ExecutorService threadExecutor;

    public CalculateTask(ExecutorService threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    public Future<Integer> calculate(Integer num) {
        return threadExecutor.submit(() -> {
            log.info("Calculate {} ^ 2", num);
            Thread.sleep(3000);
            return num * num;
        });
    }

    public void destroy() {
        threadExecutor.shutdown();
    }
}
