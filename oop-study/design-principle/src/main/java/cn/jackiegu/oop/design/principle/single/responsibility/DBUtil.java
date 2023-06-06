package cn.jackiegu.oop.design.principle.single.responsibility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class DBUtil {

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    public Connection getConnection(String url, String username, String password) throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
