package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TongPeiFuTest1 {
	public static void main(String[] args) {
		//遍历List集合
		List<Integer>  lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		
		TongPeiFuTest1 mehodTest2 = new TongPeiFuTest1();
		mehodTest2.print(lists);
		
		
		System.out.println("================================");
		List<String>  lists2 = new ArrayList<>();
		lists2.add("孙悟空是");
		lists2.add("10000");
		lists2.add("岁");
		mehodTest2.print(lists2);
	}

	/*<T> 表示声明一个泛型类型T，具体类型在使用的时候确定；
	 *其实可用任意字母如F来代替T，但通常必须要大写。 
	 *<T>通常需放在方法的返回值声明之前。
	 *T不是一个类，但因有 <T> 定义好了一个泛型类型 T，则泛型类型T作为数据类型使用*/
	private  void print(List<?> lists) {
		//编译时报错，此时集合的add方法是lists.add(T t),要求类型为T，但是T是一个泛型类型，真正的类型在使用的时候确定；
		//那么此时就不能确定T的类型，所以不能使用集合的add方法，除非是lists.add(null);
		//lists.add(null);
		//因为不确定传入到集合中的元素类型，所以get方法用Object去接
		Object t  = lists.get(0);
		for (Object o : lists) {
			System.out.println(o);
		}
	}
}
