package com.cc.Thread;

/**
 * Created by admin on 2019/4/16.
 */
public class Lock {
    //这里用private封装，为了不让外面随便造锁，限制只能有A，B锁个一把，这样容易出现死锁
    //即A同学和B同学想相互串门，可是没人只有一把自己房间的钥匙，而且各自都不愿意先给，于是死锁
    private Lock() {};
    public static final Object lockA =new Object();
    public static final Object lockB = new Object();
    //这里使用static 为了让外界可以通过类名调用成员变量lockA和lockB
    //因为外面无法创建Lock对象，为了让外面在不创对象的情况下调用，加了static，通过类名加变量名访问
}