package Annotation;

/**
 * Created by admin on 2019/4/18.
 */
@MyAnnotation2("孤傲苍狼")//等价于@MyAnnotation(value="孤傲苍狼")
public class AnnotationUse2 {
    public static void main(String[] args) {
        /**
         * 用反射方式获得注解对应的实例对象后，在通过该对象调用属性对应的方法
         */
        MyAnnotation2 annotation = (MyAnnotation2) AnnotationUse2.class.getAnnotation(MyAnnotation2.class);
        System.out.println(annotation.color());//输出color属性的默认值：blue
        System.out.println(annotation.value());
    }
}