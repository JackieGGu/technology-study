package cn.jackiegu.feature.java8.datetime;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LoggerUtil.info("LocalDate、LocalTime、LocalDateTime");
        LocalDate date = LocalDate.now();
        log.info(date.toString());
        LocalTime time = LocalTime.of(16, 5, 1);
        log.info(time.toString());
        LocalDateTime dateTime = LocalDateTime.parse("2021-04-09T16:05:01");
        log.info(dateTime.toString());
        LocalDateTime dateTime1 = dateTime.plusYears(1).minusMonths(4);
        log.info(dateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LoggerUtil.info("Instant");
        Instant now = Instant.now();
        log.info(now.toString());
    }
}
