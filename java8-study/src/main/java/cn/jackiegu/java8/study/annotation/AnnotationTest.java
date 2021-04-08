package cn.jackiegu.java8.study.annotation;

import cn.jackiegu.technology.common.util.LoggerUtil;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 注解测试类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        Class<AnnotationUser> userClass = AnnotationUser.class;

        LoggerUtil.info("张三的角色");
        Field zs = userClass.getField("zs");
        AnnotationRole[] zsRoles = zs.getAnnotation(AnnotationRoles.class).value();
        Arrays.stream(zsRoles).forEach(System.out::println);


        LoggerUtil.info("李四的角色");
        Field ls = userClass.getField("ls");
        AnnotationRole[] lsRoles = ls.getAnnotation(AnnotationRoles.class).value();
        Arrays.stream(lsRoles).forEach(System.out::println);
    }
}
