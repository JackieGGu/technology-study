package cn.jackiegu.concurrent.study.future;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 计算任务
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class CalculateTask {

    private final ExecutorService threadExecutor;

    public CalculateTask(ExecutorService threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    public Future<Integer> calculate(Integer num) {
        return threadExecutor.submit(() -> {
            System.out.println(LoggerUtil.threadName() + " Calculate " + num + " ^ 2");
            Thread.sleep(3000);
            return num * num;
        });
    }

    public void destroy() {
        threadExecutor.shutdown();
    }
}
