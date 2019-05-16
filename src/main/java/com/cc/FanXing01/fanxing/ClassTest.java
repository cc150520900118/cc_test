package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ClassTest<T> {
	public static void main(String[] args) {
		//遍历List集合
		List<Integer>  lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		
		ClassTest<Integer> classTest = new ClassTest<Integer>();
		classTest.print(lists);
		
		//编写一个方法，实现指定位置上数组元素的交换。数组的索引从0开始
		Integer[]  arr = new Integer[] {2,3,4,5,6};
		ClassTest.changeStr(arr, 1, 4);
		System.out.println(Arrays.toString(arr));
		
		
		Map<Integer, String>  maps = new HashMap<>();
		maps.put(1, "张三");
		maps.put(2, "李四");
		maps.put(3, "王麻子");
		
		printMap(maps);
	}
	
	private static <K, V> void printMap(Map<K, V> maps) {
		Set<Entry<K,V>>   entries= maps.entrySet();
		//Entry<Integer, String> ：表示集合中元素类型    entry:集合中每一个元素的代称   entries：表示你要遍历的集合
		for (Entry<K, V> entry : entries) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
	}

	//实例方法属于对象，通过对象调用，通过ClassTest<Integer>创建对象的时候，就确定了T的类型为Integer
	private   void print(List<T> lists) {
		for (T o : lists) {
			System.out.println(o);
		}
	}
	
	
	/*静态方法不能使用类定义的泛形，而应该单独定义泛形。
	静态方法用类调用 ，类调用静态方法时还没有类后面的泛型，
	所以静态方法中有泛型，必须要方法自己定义*/
	private static <F> void changeStr(F[] arrStr, int i, int j) {
		F temp = arrStr[i];
		arrStr[i] = arrStr[j];
		arrStr[j] = temp;
	}
}
