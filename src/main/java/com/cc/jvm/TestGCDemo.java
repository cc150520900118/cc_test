package com.cc.jvm;
public class TestGCDemo {
	public static void main(String[] args) throws Exception {
		java.util.Random rand = new java.util.Random() ;
		String str = "【www.mldn.cn】" ;
		while (true) {
			str += str + rand.nextInt(999999) ;
			str.intern() ;	// 入池，强制性的垃圾产生
		}
	}
}
