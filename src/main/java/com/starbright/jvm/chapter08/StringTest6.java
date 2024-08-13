package com.starbright.jvm.chapter08;

import org.junit.Test;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/12 17:39
 */
public class StringTest6 {

	@Test
	public void test1() {
		String s1 = "a" + "b" + "c"; // 等同于"abc"
		String s2 = "abc"; // "abc"肯定是放在字符串常量池中，将其地址返回给s2
		/*
		 * 最终 .java 文件编译为 .class， 再执行 .class
		 * String s1 = "abc";
		 * String s2 = "abc";
		 */
		System.out.println(s1 == s2); // true
		System.out.println(s1.equals(s2)); // true
	}

	@Test
	public void test2() {
		String s1 = "javaEE";
		String s2 = "hadoop";
		String s3 = "javaEEhadoop";
		String s4 = "javaEE" + "hadoop";// 编译期优化
		// 如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：javaEEhadoop
		String s5 = s1 + "hadoop";
		String s6 = "javaEE" + s2;
		String s7 = s1 + s2;
		System.out.println(s3 == s4);// true
		System.out.println(s3 == s5);// false
		System.out.println(s3 == s6);// false
		System.out.println(s3 == s7);// false
		System.out.println(s5 == s6);// false
		System.out.println(s5 == s7);// false
		System.out.println(s6 == s7);// false
		// intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
		// 如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回此对象的地址。
		String s8 = s6.intern();
		System.out.println(s3 == s8);// true
	}

	@Test
	public void test3() {
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
	    /*
		    如下的s1 + s2 的执行细节：(变量s是我临时定义的）
		    1、StringBuilder s = new StringBuilder();
		    2、 s.append("a")
		    3、 s.append("b")
		    4、 s.toString()  --> 约等于 new String("ab")
		    补充：在jdk5.0之后使用的是StringBuilder,在jdk5.0之前使用的是StringBuffer
	     */
		String s4 = s1 + s2;
		System.out.println(s3 == s4);// false
	}

	/**
	 * 1、 字符串拼接操作不一定使用的是StringBuilder!
	 * 如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
	 * 2、 针对于final修饰类、方法、基本数据类型、引用数据类型的量的结构时，能使用上final的时候建议使用上。
	 */
	@Test
	public void test4() {
		final String s1 = "a";
		final String s2 = "b";
		String s3 = "ab";
		String s4 = s1 + s2; // s4:常量
		System.out.println(s3 == s4);// true
	}

	/**
	 * 用于测试： 练习题
	 */
	@Test
	public void test5() {
	    String s1 = "JavaEEHadoop";
		String s2 = "JavaEE";
		String s3 = s2 + "Hadoop";
		System.out.println(s1 == s3); //false

		final String s4 = "JavaEE"; // 常量
		String s5 = s4 + "Hadoop";
		System.out.println(s1 == s5); // true
	}


	/**
	 * 用于测试：
	 */
	@Test
	public void test8() {
		String s1 = "beijing";
		String s2 = new String("beijing");
		String s3 = s2.intern();

		System.out.println(s1 == s2); // fasle
		System.out.println(s1 == s3); // true
	}

}
