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
        String url = "jdbc:mysql://mysql.jackiegu.cn:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username = "test";
        String password = "123$%^";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("DriverManager ClassLoader: " + DriverManager.class.getClassLoader());
        System.out.println("Connection ClassLoader: " + Connection.class.getClassLoader());
        System.out.println("Connection Instance ClassLoader: " + connection.getClass().getClassLoader());
        System.out.println("Connection Instance: " + connection);
    }
}
