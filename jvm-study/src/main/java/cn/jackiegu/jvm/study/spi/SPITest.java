package cn.jackiegu.jvm.study.spi;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ServiceLoader;

/**
 * 测试类
 *
 * @author JackieGu
 * @date 2021/4/23
 */
public class SPITest {

    public static void main(String[] args) throws Exception {
        LoggerUtil.info("自定义SPI");
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.move();
        }

        LoggerUtil.info("JDBC—SPI实战");
        System.out.println("DriverManager ClassLoader: " + DriverManager.class.getClassLoader());
        System.out.println("Connection ClassLoader: " + Connection.class.getClassLoader());

        LoggerUtil.info("MySQL Connection");
        String mysqlUrl = "jdbc:mysql://mysql.jackiegu.cn:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String mysqlUsername = "test";
        String mysqlPassword = "123$%^";
        Connection mysqlConnection = DriverManager.getConnection(mysqlUrl, mysqlUsername, mysqlPassword);
        System.out.println("MySQL Connection Instance ClassLoader: " + mysqlConnection.getClass().getClassLoader());
        System.out.println("MySQL Connection Instance: " + mysqlConnection);

        LoggerUtil.info("PostgreSQL Connection");
        String postgresqlUrl = "jdbc:postgresql://192.168.60.9:5432/sonarqube?currentSchema=public";
        String postgresqlUsername = "postgres";
        String postgresqlPassword = "123456";
        Connection postgresqlConnection = DriverManager.getConnection(postgresqlUrl, postgresqlUsername, postgresqlPassword);
        System.out.println("PostgreSQL Connection Instance ClassLoader: " + postgresqlConnection.getClass().getClassLoader());
        System.out.println("PostgreSQL Connection Instance: " + postgresqlConnection);
    }
}
