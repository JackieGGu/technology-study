package cn.jackiegu.oop.design.principle.i.segregation;

/**
 * 交易数据阅读器
 *
 * @author JackieGu
 * @date 2021/5/17
 */
public interface TransactionDataReader {

    /**
     * 读取数据
     *
     * @return 交易数据
     */
    Object readData();
}
