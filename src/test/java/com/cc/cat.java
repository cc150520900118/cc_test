package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
public class cat extends Animal{
    public cat(){
        //super(color,foot);         //---------------(3)
        super();    //---------------可以省略
        System.out.println("我是子类无参数构造器");
    }
    public void shout() {
        super.superdemo();//super
        System.out.println("喵喵喵！");
    }
}
