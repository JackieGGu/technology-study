package cn.jackiegu.oop.design.principle.i.segregation;

/**
 * 交易数据报表
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public class TransactionDataChart implements TransactionDataChartHandler {

    @Override
    public Object readData() {
        Object data = new Object();
        return data;
    }

    @Override
    public Object createChart() {
        // 这里省略形成报表操作
        Object chart = new Object();
        return chart;
    }

    @Override
    public void displayChart() {
        System.out.println("展示报表");
    }
}
