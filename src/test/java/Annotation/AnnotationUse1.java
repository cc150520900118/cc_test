package Annotation;

/**
 * Created by admin on 2019/4/18.
 */
@MyAnnotation1
public class AnnotationUse1 {
    public static void main(String[] args) {
        /**
         * 用反射方式获得注解对应的实例对象后，在通过该对象调用属性对应的方法
         */
        MyAnnotation1 annotation = (MyAnnotation1) AnnotationUse1.class.getAnnotation(MyAnnotation1.class);
        System.out.println(annotation.color());//输出color属性的默认值：blue
    }
}