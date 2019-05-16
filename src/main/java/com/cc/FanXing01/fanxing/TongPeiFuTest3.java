package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TongPeiFuTest3 {
	public static void main(String[] args) {
		//遍历List集合
		List<Animal>  lists = new ArrayList<>();
		lists.add(new Animal("狗", "男", 2));
		lists.add(new Animal("猫", "男", 2));
		
		TongPeiFuTest3 mehodTest2 = new TongPeiFuTest3();
		mehodTest2.print(lists);
		
		System.out.println("=========================");
		List<Cat>  cats = new ArrayList<>();
		cats.add(new Cat("旺旺", "男", 2));
		cats.add(new Cat("包子", "男", 2));
		mehodTest2.print(cats);
		
		
		/*System.out.println("=============33===================");
		List<String>  lists2 = new ArrayList<>();
		lists2.add("孙悟空是");
		lists2.add("10000");
		lists2.add("岁");
		mehodTest2.print(lists2);该方法编译报错，只能接受Animal及其子类的类型*/
	}

	/*<? super E> 有下限的通配符。能接受指定类及其父类类型的数据,E就是该泛型的下边界.
	 *改方法只能遍历Cat类型的集合与Cat父类类型的集合*/
	private  void print(List<? super Cat> lists) {
		//允许添加 Cat和Cat的子类 元素，还有null
		lists.add(new Cat("馒头", "男", 2));
		lists.add(new Chinchillas("龙猫1号", "男", 2));
		lists.add(null);
		//因为不确定传入到集合中的元素类型，所以get方法用Object去接,但是不建议使用
		//Object t  = lists.get(0);
		
		/* 可获取元素，但传入的类型可能是E到Object之间的任何类型, 也就无法确认接收的数据类型.
		所以返回只能使用Object引用来接受！如果需要自己的类型需要强制类型转换！*/
		Object animal = lists.get(0);
		for (Object o : lists) {
			System.out.println(o);
		}
	}
}
