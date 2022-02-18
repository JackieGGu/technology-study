package cn.jackiegu.technology.common.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志工具类
 *
 * @author JackieGu
 * @date 2021/4/2
 */
@Slf4j
public class LoggerUtil {

    private LoggerUtil() {
    }

    /**
     * 日志打印
     */
    public static void info(String str) {
        log.info("\033[94m" + str + "\033[0m");
    }

    /**
     * 返回线程名称
     */
    public static String threadName() {
        return "\033[92m" + Thread.currentThread().getName() + "\033[0m";
    }
}
