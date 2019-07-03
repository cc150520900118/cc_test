package com.cc.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestReferenceDemo {
	public static void main(String[] args) throws Exception {
		String str = new String("www.mldn.cn") ;
		ReferenceQueue<String> queue = new ReferenceQueue<String>();
		PhantomReference<String> pr = new PhantomReference<String>(str,queue);
		str = null ;
		System.gc(); 
		Thread.sleep(200);
		System.out.println(pr.isEnqueued());	// 有引用
		System.out.println(pr.get());	// 得不到东西
		System.out.println(queue.poll());
	}
}
