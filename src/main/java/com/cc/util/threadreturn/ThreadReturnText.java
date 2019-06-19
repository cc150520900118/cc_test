package com.cc.util.threadreturn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/4/19.
 */
public class ThreadReturnText {
    public static void main(String[] agrs){
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("hello"+i);
        }
        System.out.println("执行开始");
        ThreadPoolReturnTool<String> tool = new ThreadPoolReturnTool(10,list);
        tool.setWork(new ThreadPoolReturnTool.Work<String>() {//实现业务代码
            @Override
            public void method(List<String> list) {//返回值
                for (int i = 0; i < list.size(); i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"------"+list.get(i)+" 111111");
                }
            }
        });
        try {
            tool.excute();
            //System.out.println(String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}