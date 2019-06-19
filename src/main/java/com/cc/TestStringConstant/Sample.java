package com.cc.TestStringConstant;

/**
 * Created by admin on 2019/6/19.
 */
public class Sample {
    private String name;      //new Sample实例后， name 引用放入栈区里，  name 对象放入堆里


    public  Sample(String name)
    {
        this .name = name;
    }


    public   void  printName()   //print方法本身放入 方法区里。
    {
        System.out.println(name);
    }
}
