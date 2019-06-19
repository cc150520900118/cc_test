package com.cc.util.multipleThread.postThread;





import com.cc.util.multipleThread.listThread.ListThreadPoolTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/4/19.
 */
public class ThreadReturnText {
    public static void main(String[] agrs) {
        System.out.println("执行开始");
        int pages = 55;
        //1、线程批量分组页面list
        PostThreadPoolTool<String> tool = new PostThreadPoolTool(10, pages);
        tool.setWork(new PostThreadPoolTool.Work<String>() {
            @Override
            public void method(int xcmz, int startIndex, int endIndex) {
                List<String> list = new ArrayList<>();
                for (int i = startIndex; i <= endIndex; i++) {
                    list.add("请求第"+i+"页数据");
                }
                System.out.println("线程池1=="+xcmz+"---"+Thread.currentThread().getName()+"==分组list数据"+list.toString());
                thread2(2,list);
            }
        });
        try {
            tool.excute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void thread2(int singleCount, List<String> list){
        ListThreadPoolTool<String> tool = new ListThreadPoolTool(singleCount,list);
        tool.setWork(new ListThreadPoolTool.Work<String>() {//实现业务代码
            @Override
            public void method(int xcmz ,List<String> list) {//返回值
                System.out.println("线程池2=="+xcmz+"---"+Thread.currentThread().getName()+"------"+list.toString());
                for (int i = 0; i < list.size(); i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(Thread.currentThread().getName()+"------"+list.get(i));
                }
            }
        });
        try {
            tool.excute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}