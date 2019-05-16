package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List  list = new ArrayList();//没有泛型时，可添加所有类型的方法
		list.add("孙悟空有");
		list.add(10000);
		list.add("岁");
		
		String  name = (String) list.get(0);
		System.out.println("name:"+name);
		
		//运行时会出现强制转换异常ClassCastException：java.lang.Integer cannot be cast to java.lang.String
		//String  age = (String) list.get(1);
		//System.out.println("age:"+age);
		
		
		System.out.println("====================================");
		//JDK1.5以后引入泛型  <>内表示限定集合中只能放某种类型的元素
		List<String>  list2 = new ArrayList<String>();
		list2.add("孙悟空");
		list2.add("10000");
		list2.add("岁");
		String  name2 = list2.get(0);
		String  age2 = list2.get(1);
		String  end = list2.get(2);
		System.out.println(name2+"  "+age2+" "+end);
		//目前：我们知道使用泛型的好处：
		//一是无需进行强转，二是不会出现强制类型转换异常
	}
}
