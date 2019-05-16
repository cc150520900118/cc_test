package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



import java.util.Set;

public class CollectionTest {
	public static void main(String[] args) {
		Set<Integer>  sets = new HashSet<>();
		//1.不允许重复对象
		//2. 只允许一个 null 元素
		//3.无序容器，你无法保证每个元素的存储顺序，TreeSet通过 Comparator  或者 Comparable 维护了一个排序顺序
		sets.add(2);
		sets.add(3);
		sets.add(4);
		sets.add(null);//这里存入两个null  但是也是会出现一个null
		sets.add(null);
		Iterator<Integer> iterator = sets.iterator();//迭代器
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("============set通过forech遍历=======================");
		//Integer：表示集合中元素类型    integer:集合中每一个元素的代称   sets：表示你要遍历的集合
		for (Integer integer : sets) {
			System.out.println(integer);
		}
		
		System.out.println("===============map集合遍历====================");
		Map<Integer, String>  maps = new HashMap<>();
		maps.put(1, "张三");
		maps.put(2, "李四");
		maps.put(3, "王麻子");
		
		Set<Entry<Integer,String>>   entries= maps.entrySet();
		//Entry<Integer, String> ：表示集合中元素类型    entry:集合中每一个元素的代称   entries：表示你要遍历的集合
		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		
		//泛型不接受 8 种基本数据类型，必须申明引用类型
		//Map<int, String>  maps2 = new HashMap<>();//编译时报错，int是基本类型
		//List 1.可以允许重复的对象。2.可以插入多个null元素。3、有序容器，保持了每个元素的插入顺序，输出的顺序就是插入的顺序
		Animal  animal = new Cat("11", "11", 11);
		//Cat继承Animal，但List<Cat> 和 List<Animal> 没有有继承关系
		//List<Animal>  animals = new ArrayList<Cat>();
		List<Animal>  animals = new ArrayList<Animal>();
		List<Animal>  animals2 = new ArrayList<>();
	}
}
