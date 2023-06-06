package cn.jackiegu.oop.design.principle.single.responsibility;

/**
 * 销售数据报表形成于展示
 *
 * @author JackieGu
 * @date 2021/5/14
 */
public class SaleDataChart {

    /**
     * 形成报表
     *
     * @return 报表
     */
    public Object createChart() {
        // 这里省略销售数据查询和形成报表操作
        // ......
        return new Object();
    }

    /**
     * 展示报表
     */
    public void displayChart() {
        Object chart = this.createChart();
        System.out.println(chart);
    }
}
