package com.cc.FanXing01.fanxing;

import java.util.Arrays;

public class MehodTest {
	public static void main(String[] args) {
		//编写一个方法，实现指定位置上数组元素的交换。数组的索引从0开始
		Integer[]  arr = new Integer[] {2,3,4,5,6};
		//System.out.println(arr[1]);
		
		//change(arr,1,4);
		// [2, 6, 4, 5, 3]
		changeStr(arr, 1, 4);
		System.out.println(Arrays.toString(arr));
		
		String[]  arrStr = new String[] {"孙悟空","是","10000岁"};
		changeStr(arrStr,0,2);
		System.out.println(Arrays.toString(arrStr));
	}
	
	/*<T> 表示声明一个泛型类型T，具体类型在使用的时候确定；
	 *其实可用任意字母如F来代替T，但通常必须要大写。 
	 *<T>通常需放在方法的返回值声明之前。
	 *T不是一个类，但因有 <T> 定义好了一个泛型类型 T，则泛型类型T作为数据类型使用*/
	private static <T> void changeStr(T[] arrStr, int i, int j) {
		T temp = arrStr[i];
		arrStr[i] = arrStr[j];
		arrStr[j] = temp;
	}

	/**
	 * 此时该方法只能交换Integer[]中指定位置的元素
	 * @param integers 要进行换位置的数组
	 * @param begin 要进行交互位置的元素的索引  1
	 * @param end 要进行交互位置的元素的索引  4
	 */
	/*public static void change(Integer[]  arr,int i,int j) {
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}*/
}
