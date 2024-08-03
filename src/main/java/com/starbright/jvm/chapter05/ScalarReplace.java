package com.starbright.jvm.chapter05;

/**
 * 标量替换测试
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 */
public class ScalarReplace {

	public static class User {
		public int id;
		public String name;
	}

	public static void alloc() {
		// 未发生逃逸
		User u = new User();
		u.id = 5;
		u.name = "www.baidu.com";
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			alloc();
		}
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为： " + (end - start) + " ms");
	}
}
