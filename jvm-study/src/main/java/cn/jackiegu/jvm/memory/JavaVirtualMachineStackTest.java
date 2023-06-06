package cn.jackiegu.jvm.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * Java虚拟机栈测试
 * VM Args: -Xss128k
 *
 * @author JackieGu
 * @date 2021/4/30
 */
@Slf4j
public class JavaVirtualMachineStackTest {

    private Integer number = 1;

    public void overflow() {
        this.number++;
        overflow();
    }

    public void overflow(String message) {
        this.number++;
        char[] chars = new char[message.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = message.charAt(i);
        }
        String newMessage = new String(chars);
        overflow(newMessage);
    }

    public static void main(String[] args) {
        JavaVirtualMachineStackTest javaVirtualMachineStackTest = new JavaVirtualMachineStackTest();
        try {
            // StackOverflowError异常测试
            // javaVirtualMachineStackTest.overflow();
            javaVirtualMachineStackTest.overflow("java vm stack");
        } catch (Error e) {
            log.info("number: {}", javaVirtualMachineStackTest.number, e);
        }
    }
}
