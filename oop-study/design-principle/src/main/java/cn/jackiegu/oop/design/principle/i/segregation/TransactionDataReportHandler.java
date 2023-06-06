package cn.jackiegu.oop.design.principle.i.segregation;

/**
 * 交易数据报告处理器
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public interface TransactionDataReportHandler extends TransactionDataReader {

    Object createReport();

    void uploadReport();
}
