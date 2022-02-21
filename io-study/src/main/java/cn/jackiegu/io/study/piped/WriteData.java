package cn.jackiegu.io.study.piped;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PipedWriter;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 管道流输出数据
 *
 * @author JackieGu
 * @date 2021/4/28
 */
@Slf4j
public class WriteData extends Thread {

    private final PipedWriter writer;

    public WriteData(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            Random random = new SecureRandom();
            while (true) {
                int number = random.nextInt(100);
                if (number == 0) {
                    break;
                }
                writer.write(Thread.currentThread().getName() + "@" + number);
                TimeUnit.SECONDS.sleep(3);
            }
            writer.close();
        } catch (IOException | InterruptedException e) {
            log.error("write data failure", e);
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
