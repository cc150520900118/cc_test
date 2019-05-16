package com.cc.FanXing01.fanxing;

import java.util.ArrayList;
import java.util.List;

public class FangXingLast {
	public static void main(String[] args) {
		List<String>  listStr = new ArrayList<>();
		List<Integer>  listInt = new ArrayList<>();
		//getClass() 返回此 Object的运行时类。
		System.out.println(listStr.getClass());
		System.out.println(listInt.getClass());
		System.out.println(listStr.getClass() == listInt.getClass());
	}
}
