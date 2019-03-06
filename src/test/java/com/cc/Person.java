package com.cc;

/**
 * Created by changc on 2019/3/2.
 */
public class Person implements Sleep,Eat,Study{

    @Override
    public void ioStudy() {
        System.out.println("我是人，我每天都要学习");
    }

    @Override
    public void ioEat() {
        System.out.println("我是人，我要吃大鱼大肉还要喝酒");
    }

    @Override
    public void ioSleep(int i) {
        System.out.println("我是人，我每天要睡24小时");
    }
}