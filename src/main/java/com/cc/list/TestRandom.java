package com.cc.list;

import java.util.Random;

/**
 * Created by admin on 2019/6/22.
 */
//获取100以内的随机数
public class TestRandom {
    public static void main(String[] args) {
        //直接使用Math.random()这个静态的方法，random()方法返回一个[0,1)的随机数；
        System.out.println("Method one:" + Math.random() * 100);
        //使用java.util.Random类，创建一个实例，使用nextInt(int count)获得count以内的整数，不含count
        Random random = new Random();
        System.out.println("Method two:" + random.nextInt(100));
    }
}

