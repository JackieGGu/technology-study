package cn.jackiegu.feature.java8.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试角色注解
 *
 * @author JackieGu
 * @date 2021/4/8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Repeatable(AnnotationRoles.class)
public @interface AnnotationRole {

    String value() default "";
}
