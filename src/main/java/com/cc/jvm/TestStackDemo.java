package com.cc.jvm;
public class TestStackDemo {
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime() ;
		// 默认情况下分配给JVM的最大内存空间：总内存的四分之一
		System.out.println("MAX_MEMORY = " + run.maxMemory() + "（"+((double) run.maxMemory() / 1024 / 1024)+"兆）");
		// 默认情况下除了伸缩区之外的可用内存空间
		System.out.println("TOTAL_MEMORY = " + run.totalMemory() + "（"+((double) run.totalMemory() / 1024 / 1024)+"兆）");
		System.out.println("FREE_MEMORY = " + run.freeMemory() + "（"+((double) run.freeMemory() / 1024 / 1024)+"兆）");
	}
}
