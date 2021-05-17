package cn.jackiegu.design.principle.study.i.segregation;

/**
 * 交易数据报表处理器
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public interface TransactionDataChartHandler extends TransactionDataReader {

    Object createChart();

    void displayChart();
}
