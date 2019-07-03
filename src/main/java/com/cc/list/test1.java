package com.cc.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by admin on 2019/7/1.
 * Java中Stream和parallelStream，前者是单管，后者是多管，运行时间上做一个小对比
 * 测试结果：
 * stream : 10000




 */
public class test1 {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        //模拟10000条数据 forEach打印测试
        List<Integer> list = new ArrayList();
        for (int j = 0; j < 4000; j++) {
            list.add(j);
        }
        //下面测试下各方法执行的时间 检查效率
        parallellockStreamtest(list);
        fortest(list);
        streamtest(list);
        parallelStreamtest(list);
        parallellockStreamtest(list);


    }
    public static void fortest(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            try {
                list1.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for : " + list1.size());
        System.out.println("传统for循环运行时间:" + (endTime - startTime) + "ms");

    }
    // 测试单管道stream执行效率
    public static void streamtest(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        list.stream().forEach(r -> {
            try {
                list1.add(r);
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long streamendTime = System.currentTimeMillis();
        System.out.println("stream : " + list1.size());
        System.out.println("stream运行时间: " + (streamendTime - startTime) + "ms");
    }
    // 测试多管道parallelStream 执行效率
    //IntStream.range(0, 100000).parallel().forEach(r -> {list.get(r)})
    public static void parallelStreamtest(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        // 测试多管道parallelStream执行效率
        long startTime = System.currentTimeMillis();
        list.parallelStream().forEach(r -> {
            try {
                list1.add(r);
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long parallelStreamendTime1 = System.currentTimeMillis();
        System.out.println("parallelStream : " + list1.size());
        System.out.println("parallelStream运行时间: " + (parallelStreamendTime1 - startTime) + "ms");
    }
    // 测试多管道parallelStream 加锁执行效率
    // IntStream.range(0, 100000).parallel().forEach(r -> {list.get(r)})  加锁
    public static void parallellockStreamtest(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        list.parallelStream().forEach(r -> {
            synchronized(list){
                try {
                    list1.add(r);
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        long parallelStreamendTime = System.currentTimeMillis();
        System.out.println("parallellockStream : " + list1.size());
        System.out.println("parallellockStreamtest运行时间: " + (parallelStreamendTime - startTime) + "ms");
    }
    public static void parallellockStreamtest2(List<Integer> list){
        Lock lock = new ReentrantLock();
        List<Integer> list1 = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        list.parallelStream().forEach(r -> {
            lock.lock();
            try {
                list1.add(r);
            }finally {
                lock.unlock();
            }
        });
        long parallelStreamendTime = System.currentTimeMillis();
        System.out.println("parallellockStream : " + list1.size());
        System.out.println("parallellockStreamtest运行时间: " + (parallelStreamendTime - startTime) + "ms");
    }
}
