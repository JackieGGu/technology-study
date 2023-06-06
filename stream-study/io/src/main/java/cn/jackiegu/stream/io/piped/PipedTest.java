package cn.jackiegu.stream.io.piped;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道流测试类
 *
 * @author JackieGu
 * @date 2021/4/28
 */
public class PipedTest {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        WriteData writeData = new WriteData(writer);
        ReadData readData = new ReadData(reader);
        writeData.start();
        readData.start();
    }
}
