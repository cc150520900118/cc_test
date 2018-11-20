package com.cc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//由打印结果可知：m1方法是用到了多线程的，
// 多线程此时被线程池管理；而m2方法始终是main主线程执行的。
//采用先把要执行的“耗时”内容放到一个线程的执行主体(run方法)里面，再用线程池执行该线程，
// 可大大减少for循环的耗时。但这种情况不适合for次数较大的情形，
// 因为每循环一次，就开辟一个线程，开销较大。注意这种不叫高并发，
// 只是相当于原来由一个工人干的活现在由多个工人协作完成一样


public class TreadFor {
    private static final int loopNum = 1*10;
    
    public static void main(String args[]) throws InterruptedException {  
    	TreadFor TestThreadPool = new TreadFor();  
        long bt = System.currentTimeMillis();  
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("7");
        list.add("8");
        list.add("9");
        TestThreadPool.m1(list);  
        long et2 = System.currentTimeMillis();  
        System.out.println("[1]耗时:"+(et2 - bt)+ "ms");  
        //Thread thread = new Thread();
        //long at = System.currentTimeMillis();
        //TestThreadPool.m2();
       // long et3 = System.currentTimeMillis();
        //System.out.println("[2]耗时:"+(et3 - at)+ "ms");
          
    }  
  
    public void m1( List<String> list) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < list.size(); i++) {
        	String str = list.get(i);
        	//System.out.println(list.get(i));
            Runnable run = new Runnable() {  
                public void run() {  
                    try {  
                        new Thread().sleep(1000);
                        //模拟耗时操作
                    	System.out.println("[1]" + Thread.currentThread().getName()+"----"+str);
                    } catch (Exception e) {  
                    }  
                }  
            }; 
            pool.execute(run);  
		
		}
        System.out.println("[1] done!");
        pool.shutdown();  
    }  
  
    public void m2() { 
    	AtomicInteger connectionIds = new AtomicInteger(0);
        for (int index = 0; index < loopNum; index++) {  
            try {  
                new Thread().sleep(1000);  //模拟耗时操作
                System.out.println("[2]" + Thread.currentThread().getName());
                
            } catch (Exception e) {  
                e.printStackTrace();  
            } 
        }  
        System.out.println("[2] done!");
    }  
}