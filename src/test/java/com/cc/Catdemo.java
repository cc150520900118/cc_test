package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
public class Catdemo implements Sleep,Eat{

    @Override
    public void ioSleep(int i) {
        System.out.println("我是猫，我每天都不用睡觉！！！");
    }

    @Override
    public void ioEat() {
        System.out.println("我是猫，我吃猫粮！！！");
    }
}