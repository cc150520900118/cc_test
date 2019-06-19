package com.cc.util.wathread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/4/19.
 */
public class ThreadText {
    public static void main(String[] agrs){
        //System.out.println(WA()[0]);
        int i=0;
        while (i<3) {
            String[] WAs =WA();
            if("1".equals(WAs[0])){
                System.out.println("成功获取到网安结果------------");
                i=3;
            }else {
                i++;
            }
        }



    }



    public static String[] WA(){
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        Map<String, Object> reslutlist = new HashMap<>();
        list.add("新网安接口1");
        list.add("新网安接口2");
        System.out.println("调取网安开始------------");
        final String[] flag = {""};
        LatchThreadPoolTool<String> tool = new LatchThreadPoolTool(list);
        tool.setCallBack(new LatchThreadPoolTool.CallBack<String>() {//实现返回值
            @Override
            public void method(Map<String, Object> list) {//返回值
                System.out.println("获取网安结果------------"+ list.get("0"));
                System.out.println("获取网安结果------------"+ list.get("1"));
                if(!list.get("0").equals("")||!list.get("1").equals("")){
                    System.out.println("调取网安成功------------");
                    flag[0] ="1";
                }else{
                    System.out.println("调取网安失败------------");
                    flag[0] ="2";
                }
            }
        });
        try {
            tool.excute();
            System.out.println("调取网安结束------------");
            System.out.println(String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }
}