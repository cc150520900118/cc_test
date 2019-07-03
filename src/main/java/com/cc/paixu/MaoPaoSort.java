package com.cc.paixu;

/**
 * Created by admin on 2019/6/27.
 */
//用java实现一个冒泡排序算法
public class MaoPaoSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {3, 5, 7, 1, 8, 11, 9};	//定义数组
        maoPaoSort(arr);					//开始排序
    }
    //冒泡排序算法
    public static void maoPaoSort(int[] arrays) {
        //定义临时变量temp
        int temp = 0;
        //用j为下标，遍历数组
        for (int j = 0; j < arrays.length; j++) {
            //对每一个数组元素，从0到还未来排序的最大下标，总是把最大的数字放在后面
            for (int k = 0; k < arrays.length - j -1; k++) {
                if (arrays[k] > arrays[k + 1]) {	//判断当前数字与后面数字的大小
                    temp = arrays[k];
                    arrays[k] = arrays[k + 1];
                    arrays[k + 1] = temp;			//用temp变量进行换值
                }
            }
        }
        maoPaoPrint(arrays);					//打印
    }

    //打印方法
    private static void maoPaoPrint(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {	//遍历
            System.out.print(arrays[i] + " ");	//打印，以空格隔开
        }
        System.out.println(); 					//换行
    }
}