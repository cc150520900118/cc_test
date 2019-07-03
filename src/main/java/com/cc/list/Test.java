package com.cc.list;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;

/**
 * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 */

public class Test {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        List<String> list3 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        boolean k=list2.contains("3333");
        System.out.println("---是否包含3333---"+k);

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);




        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEach(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEach(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEach(System.out :: println);

        // 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题

    }
}
