package com.starbright.jvm.chapter08;


public class StringIntern {
	public static void main(String[] args) {
		/*
		 *	此时创建两个对象：
		 *	对象一：在堆中 new String()
		 *	对象二：字符串常量池 "1"
		 */
		String s1 = new String("1");
		// 此处的intern没啥意义，因为在字符串常量池中已存在"1"，所以对应的s1地址没有变化，还是堆中的地址
		s1.intern();
		// 此时s2的地址是常量池的地址
		String s2 = "1";
		// jdk6: false jdk7/8:false
		System.out.println(s1 == s2);

		/*
		 * 此时创建三个对象，其实也可以说是四个对象
		 * 对象一：new StringBuffer
		 * 对象二：new String("1")
		 * 对象三：new String("1")
		 * 对象四：StringBuffer.toString --> new String("11")
		 * 注意：此时在字符串常量池并没有"11"
		 */
		// s3 变量的地址是 new String("11") 的地址
		String s3 = new String("1") + new String("1");
		// 此时s3.intern会在字符串常量池中生成"11"并把字符串常量池的地址指向s3的地址（本质是为了节省空间，字符串常量池"11"的地址指向s3的引用地址）
		s3.intern();
		String s4 = "11";
		// jdk6:false jdk7/jdk8:true
		System.out.println(s3 == s4);
	}
}
