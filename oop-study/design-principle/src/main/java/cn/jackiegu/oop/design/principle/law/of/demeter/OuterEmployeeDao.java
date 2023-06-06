package cn.jackiegu.oop.design.principle.law.of.demeter;

import java.util.List;

/**
 * 外派员工Dao
 *
 * @author JackieGu
 * @date 2021/5/18
 */
public interface OuterEmployeeDao {

    List<OuterEmployee> findOuterEmployee();
}
