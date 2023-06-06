package cn.jackiegu.stream.io.piped;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PipedReader;

/**
 * 管道流输入数据
 *
 * @author JackieGu
 * @date 2021/4/28
 */
@Slf4j
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
                log.info(message);
            }
        } catch (IOException e) {
            log.error("read data failure", e);
        }
    }
}
