package cn.jackiegu.feature.java8.annotation;

/**
 * 测试用户类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class AnnotationUser {

    @AnnotationRoles({@AnnotationRole("role1"), @AnnotationRole("role2")})
    public AnnotationUser zs = new AnnotationUser();

    @AnnotationRole("role3")
    @AnnotationRole("role4")
    public AnnotationUser ls = new AnnotationUser();
}
