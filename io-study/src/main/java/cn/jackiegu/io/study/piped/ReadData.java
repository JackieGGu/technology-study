package cn.jackiegu.io.study.piped;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.io.IOException;
import java.io.PipedReader;

/**
 * 管道流输入数据
 *
 * @author JackieGu
 * @date 2021/4/28
 */
public class ReadData extends Thread {

    private final PipedReader reader;

    public ReadData(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            char[] chars = new char[1024];
            while ((reader.read(chars)) != -1) {
                String message = new String(chars);
                System.out.println(LoggerUtil.threadName() + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
