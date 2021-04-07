package cn.jackiegu.jvm.study.classloader;

import cn.jackiegu.jvm.study.common.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * java SPI机制测试
 *
 * @author JackieGu
 * @date 2021/4/6
 */
public class SpiTest {

    public static void main(String[] args) throws Exception {
        // String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://106.12.95.129:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "1$=mysqlyuan";

        // Class.forName(driver);
        /*
         * 1. DriverManager类的静态块代码中加载初始驱动
         * 2. DriverManager类的加载初始驱动方法中使用了ServiceLoader去得到Driver的实现类
         * 3. ServiceLoader类采用应用类加载器(通过当前线程上下文中获取)去加载Driver的实现类
         * 4. 在Driver的实现类的静态块代码中调用DriverManager.registerDriver()方法进行反向注册
         */
        Connection connection = DriverManager.getConnection(url, username, password);
        Utils.logger("Connection类加载器与实例");
        System.out.println(connection.getClass().getClassLoader());
        System.out.println(connection);
    }
}
