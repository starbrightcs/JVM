package com.starbright.jvm.chapter08;


public class StringNewTest {
	public static void main(String[] args) {
		// 这里会创建几个对象？
		/*
			两个对象：
			1、一个是通过new关键字在堆中创建的
			2、另外一个是在字符串常量池中的对象，通过ldc关键字
		 */
		String s1 = new String("ab");

		// 这里会创建几个对象？
		/*
		 * 六个对象或者五个对象（对象六不算）
		 * 对象一：new StringBuilder
		 * 对象二：new String("c")
		 * 对象三：字符串常量值中的 "c"
		 * 对象四：new String("d")
		 * 对象五：字符串常量值中的 "d"
		 *
		 * 深入剖析
		 * 对象六：StringBuilder.toString() --> new String("cd")
		 * 注意：toString() 调用后在常量池不存在"ab"
		 */
		String s2 = new String("c") + new String("d");
	}
}
