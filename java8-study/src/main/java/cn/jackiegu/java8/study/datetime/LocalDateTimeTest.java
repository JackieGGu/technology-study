package cn.jackiegu.java8.study.datetime;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate、LocalTime、LocalDateTime测试类
 *
 * @author JackieGu
 * @date 2021/4/9
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LoggerUtil.info("LocalDate、LocalTime、LocalDateTime");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalTime time = LocalTime.of(16, 5, 1);
        System.out.println(time);
        LocalDateTime dateTime = LocalDateTime.parse("2021-04-09T16:05:01");
        System.out.println(dateTime);
        LocalDateTime dateTime1 = dateTime.plusYears(1).minusMonths(4);
        System.out.println(dateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LoggerUtil.info("Instant");
        Instant now = Instant.now();
        System.out.println(now);
    }
}
