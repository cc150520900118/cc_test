package com.cc;

import com.cc.bean.Animal;
import com.cc.bean.Cat;


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
		sets.add(2);
		sets.add(3);
		sets.add(4);
		
		Iterator<Integer> iterator = sets.iterator();
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
		//1、map 转成list
		Set<Entry<Integer,String>>   entries= maps.entrySet();
		//Entry<Integer, String> ：表示集合中元素类型    entry:集合中每一个元素的代称   entries：表示你要遍历的集合
		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		//第二种遍历
		for (Integer key : maps.keySet()) {
			System.out.println("key= "+ key + " and value= " + maps.get(key));
		}
		for (String v : maps.values()) {
			System.out.println("value= " + v);
		}


		//泛型不接受 8 种基本数据类型，必须申明引用类型
		//Map<int, String>  maps2 = new HashMap<>();//编译时报错，int是基本类型
		
		Animal animal = new Cat("","",12);
		//Cat继承Animal，但List<Cat> 和 List<Animal> 没有有继承关系
		//List<Animal>  animals = new ArrayList<Cat>();
		List<Animal>  animals = new ArrayList<Animal>();
		List<Animal>  animals2 = new ArrayList<>();
	}
}
