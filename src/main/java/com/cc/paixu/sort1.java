package com.cc.paixu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin on 2019/6/27.
 */
public class sort1 {
    public static void main(String[] args) {
        List<User1> list2 = new ArrayList<User1>();
        list2.add(new User1("张三", 5));
        list2.add(new User1("李四", 30));
        list2.add(new User1("王五", 19));
        list2.add(new User1("陈十七", 17)); // 陈十七永远十七岁
        Collections.sort(list2, new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                int diff = o1.getAge() - o2.getAge();
                if (diff > 0) {
                    return 1;
                }else if (diff < 0) {
                    return -1;
                }
                return 0; //相等为0
            }
      }); // 按年龄排序
      System.out.println(list2.toString());

    }
}
