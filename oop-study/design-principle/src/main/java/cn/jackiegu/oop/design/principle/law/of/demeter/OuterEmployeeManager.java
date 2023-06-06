package cn.jackiegu.oop.design.principle.law.of.demeter;

import java.util.List;

/**
 * 外派员工管理器
 *
 * @author JackieGu
 * @date 2021/5/18
 */
public class OuterEmployeeManager {

    private OuterEmployeeDao outerEmployeeDao;

    public List<OuterEmployee> findOuterEmployee() {
        return outerEmployeeDao.findOuterEmployee();
    }

    /**
     * 展示外派员工
     */
    public void displayOuterEmployee() {
        List<OuterEmployee> outerEmployee = this.findOuterEmployee();
        for (OuterEmployee employee : outerEmployee) {
            System.out.println(employee);
        }
    }
}
