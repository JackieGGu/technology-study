package cn.jackiegu.oop.design.principle.single.responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 销售数据Dao类
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class SaleDataDao {

    /**
     * 查询销售数据
     *
     * @return 销售数据
     */
    public List<?> findSaleData() {
        // 这里省略获取数据库连接和从数据库查询数据操作
        // ......
        return new ArrayList<>();
    }
}
