package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
public class cat1 extends AbstractAnimal{

    @Override
    public void eat() {
        System.out.println("我是猫，我吃的是猫粮呀");

    }

    @Override
    public void sleep() {
        System.out.println("我是猫，我比你们人类睡的时间短！");

    }
}
