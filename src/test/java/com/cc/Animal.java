package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
public class Animal {
    private String color;
    private int foot;
    public Animal(){
        System.out.println("我是父类无参数构造器");
    }
    public Animal(String color,int foot){
        System.out.println("我是父类有参数构造器");
        this.color = color;
        this.foot  = foot;
    }
    public void shout() {
        System.out.println("叫了一声");
    }
    public void superdemo() {
        System.out.println("lalalalal");
    }
}
