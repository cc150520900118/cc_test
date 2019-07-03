package pk2;

import pk1.Father;

/**
 * Created by admin on 2019/6/28.
 */
public class Child2 extends Father{
    public static void main(String[] args) {
        Father father = new Father();
        //System.out.println(father.param2);
        System.out.println(father.param3);
        //System.out.println(father.param4);

        Child2 child = new Child2();
        System.out.println(child.param2);
        System.out.println(child.param3);
       //System.out.println(child.param4);
    }
}