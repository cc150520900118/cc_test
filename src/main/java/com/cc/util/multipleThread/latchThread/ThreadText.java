package com.cc.util.multipleThread.latchThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/4/19.
 */
public class ThreadText {
    public static void main(String[] agrs){
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("hello"+i);
        }
        //System.out.println("执行开始");
        LatchThreadPoolTool<String> tool = new LatchThreadPoolTool(10,list);
        tool.setCallBack(new LatchThreadPoolTool.CallBack<String>() {//实现返回值
            @Override
            public void method(List<String> list) {//返回值

            }
        });
        try {
            tool.excute();
            System.out.println(String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}