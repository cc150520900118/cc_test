package pk1;

/**
 * Created by admin on 2019/6/28.
 */
public class Child extends Father{
    public static void main(String[] args) {
        Father father = new Father();
        System.out.println(father.param2);
        System.out.println(father.param3);
        System.out.println(father.param4);

        Child child = new Child();
        System.out.println(child.param2);
        System.out.println(child.param3);
        System.out.println(child.param4);
    }
}