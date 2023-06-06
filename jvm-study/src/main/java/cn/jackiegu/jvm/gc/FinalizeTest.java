package cn.jackiegu.jvm.gc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * finalize自我拯救测试
 *
 * @author JackieGu
 * @date 2022/5/5
 */
@Slf4j
public class FinalizeTest {

    private static FinalizeTest SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        log.info("finalize method executed");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeTest();

        SAVE_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (SAVE_HOOK != null) {
            log.info("yes, i am still alive...");
        } else {
            log.info("no, i am dead!!!");
        }

        SAVE_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if (SAVE_HOOK != null) {
            log.info("yes, i am still alive...");
        } else {
            log.info("no, i am dead!!!");
        }
    }
}
