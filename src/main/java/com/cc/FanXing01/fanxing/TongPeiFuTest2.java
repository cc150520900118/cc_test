package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TongPeiFuTest2 {
	public static void main(String[] args) {
		//遍历List集合
		List<Animal>  lists = new ArrayList<>();
		lists.add(new Animal("狗", "男", 2));
		lists.add(new Animal("猫", "男", 2));
		
		TongPeiFuTest2 mehodTest2 = new TongPeiFuTest2();
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

	/*<? extends E>有上限的通配符，能接受指定类及其子类类型的数据，E是该泛型的上边界.
	 *改方法只能遍历Animal类型的集合与Animal子类类型的集合*/
	private  void print(List<? extends Animal> lists) {
		//不能确定传入到方法的类型，所以不能使用集合的add方法，除非是lists.add(null);
		//lists.add(null);
		
		//因为不确定传入到集合中的元素类型，所以get方法用Object去接,但是不建议使用
		//Object t  = lists.get(0);
		
		/*可以获取元素，但是必须使用 E 来接受元素！
		因不管存入什么数据类型都是E的子类型*/
		Animal animal = lists.get(0);
		for (Object o : lists) {
			System.out.println(o);
		}
	}
}
