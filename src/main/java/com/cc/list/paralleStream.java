package com.cc.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by admin on 2019/6/21.
 * 并且每次的结果中并行执行的大小不一致，
 * 而串行和加锁后的结果一直都是正确结果。显而易见，stream.parallel.forEach()中执行的操作并非线程安全。
 * 串行执行的大小：100000
   并行执行的大小：87529
   加锁并行执行的大小：10000
 *
 *
 *
 */
public class paralleStream {
    private static List<Integer> list0 = new ArrayList<>();
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static List<Integer> list3 = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {

        long start0 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            list0.add(i);
        }
        System.out.println("for循环执行的大小：" + list0.size());
        long end0 = System.currentTimeMillis();
        System.out.println("耗时1：" + (end0- start0) + "  ms");


        long start = System.currentTimeMillis();
        IntStream.range(0, 100000).forEach(list1::add);
        System.out.println("串行执行的大小：" + list1.size());
        long end = System.currentTimeMillis();
        System.out.println("耗时1：" + (end - start) + "  ms");


        long start1 = System.currentTimeMillis();
        IntStream.range(0, 100000).parallel().forEach(
                list2::add);
        System.out.println("并行执行的大小：" + list2.size());
        long end1 = System.currentTimeMillis();
        System.out.println("耗时1：" + (end1 - start1) + "  ms");


        long start2 = System.currentTimeMillis();
        IntStream.range(0, 100000).forEach(i -> {
            lock.lock();
            try {
                list3.add(i);
            }finally {
                lock.unlock();
            }
        });
        long end2 = System.currentTimeMillis();
        System.out.println("加锁并行执行的大小：" + list3.size());
        System.out.println("耗时1：" + (end2 - start2) + "  ms");
    }
}
