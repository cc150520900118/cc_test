package com.cc.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 2019/4/28.
 */
public class Test3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> l1 = new ArrayList<String>();
        l1.add("a");
     /*   l1.add("a");
        l1.add("c");*/
        l1.add("b");
        l1.add("c");

        List<String> l2 = new ArrayList<String>();
        //l2.add("b");
        l2.add("b");
        l2.add("k");
       // l2.add("k");

        l1.removeAll(l2);//此处指的是将与l2重复的删除
        l1.addAll(l2);//此处指加上l2

        //如果保证l1,和l2  2个各自的LIST 本身不重复，此行代码不用写。否则会出现合并后LIST重复的问题，具体看业务需要
        //l1 = new ArrayList<String>(new HashSet<>(l1));

        for(String str : l1){
            System.out.println(str);
        }

    }

}