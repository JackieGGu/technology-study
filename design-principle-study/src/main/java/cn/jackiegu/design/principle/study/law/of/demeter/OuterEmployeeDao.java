package cn.jackiegu.design.principle.study.law.of.demeter;

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
