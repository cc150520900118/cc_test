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
 * 串行执行的大小：100000   for
   并行执行的大小：87529  并行流   stream
   加锁并行执行的大小：10000  并行流   parallelStream
 *
 *
 *
 */
public class paralleStreamList {
    private static List<Integer> list0 = new ArrayList<>();
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
        List<Integer> filterLists = new ArrayList<>();
        for(int i=0;i<10000000;i++)
        {
            filterLists.add(i);
        }

        Date a = new Date();
        for(int j=0;j<10000000;j++)
        {
            try {
                //Thread.sleep(1000);
                list0.add(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(filterLists.get(j));
        }
        Date b = new Date();

        Date c = new Date();
        filterLists.stream().forEach(s -> {
            try {
                //Thread.sleep(1000);
                list1.add(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(s);
          });
        Date d = new Date();


        Date c1 = new Date();
        filterLists.parallelStream().forEach(J ->  {
            lock.lock();
            try {
               // System.out.println(J);
                list2.add(J);
            }finally {
                lock.unlock();
            }
        });
        Date d1= new Date();
        long interval = b.getTime()-a.getTime();
        long interval2 = d.getTime()-c.getTime();
        long interval3 = d1.getTime()-c1.getTime();
        System.out.println("for循环:"+interval+"循环数量:"+list0.size());//50023
        System.out.println("stream:"+interval2+"循环数量:"+list1.size());//25086
        System.out.println("parallelStream:"+interval3+"循环数量:"+list2.size());//25089
    }

}
