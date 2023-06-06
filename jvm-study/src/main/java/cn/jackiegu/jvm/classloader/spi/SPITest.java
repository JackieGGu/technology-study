package cn.jackiegu.jvm.classloader.spi;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ServiceLoader;

/**
 * SPI测试
 *
 * @author JackieGu
 * @date 2021/4/23
 */
@Slf4j
public class SPITest {

    public static void main(String[] args) throws Exception {
        LoggerUtil.info("自定义SPI");
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.move();
        }

        LoggerUtil.info("JDBC—SPI实战");
        log.info("DriverManager ClassLoader: {}", DriverManager.class.getClassLoader());
        log.info("Connection ClassLoader: {}", Connection.class.getClassLoader());

        LoggerUtil.info("MySQL Connection");
        String mysqlUrl = "jdbc:mysql://aliyun.chengdu.mysql.jackiegu.cn:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String mysqlUsername = "test";
        String mysqlPassword = "1$=testYuan";
        Connection mysqlConnection = DriverManager.getConnection(mysqlUrl, mysqlUsername, mysqlPassword);
        log.info("MySQL Connection Instance ClassLoader: {}", mysqlConnection.getClass().getClassLoader());
        log.info("MySQL Connection Instance: {}", mysqlConnection);

        LoggerUtil.info("PostgreSQL Connection");
        String postgresqlUrl = "jdbc:postgresql://vm009:5432/sonarqube?currentSchema=public";
        String postgresqlUsername = "postgres";
        String postgresqlPassword = "123456";
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrl, postgresqlUsername, postgresqlPassword);
        log.info("PostgreSQL Connection Instance ClassLoader: {}", postgresqlConnection.getClass().getClassLoader());
        log.info("PostgreSQL Connection Instance: {}", postgresqlConnection);
    }
}
