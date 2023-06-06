package cn.jackiegu.oop.design.principle.law.of.demeter;

import java.util.List;

/**
 * 员工管理器
 *
 * @author JackieGu
 * @date 2021/5/18
 */
public class EmployeeManager {

    private InnerEmployeeDao innerEmployeeDao;

    public List<InnerEmployee> findInnerEmployee() {
        return innerEmployeeDao.findInnerEmployee();
    }

    /**
     * 展示员工
     * @param outerEmployeeManager 外派员工管理器
     */
    public void displayEmployee(OuterEmployeeManager outerEmployeeManager) {
        List<InnerEmployee> innerEmployee = this.findInnerEmployee();
        for (InnerEmployee employee : innerEmployee) {
            System.out.println(employee);
        }

        outerEmployeeManager.displayOuterEmployee();
    }
}
