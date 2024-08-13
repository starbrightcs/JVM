package com.starbright.jvm.chapter08;

import org.junit.Test;

public class StringInternTest {

	/**
	 * 用于测试：String#intern练习
	 */
	@Test
	public void test1() {
		String s = new String("a") + new String("b");
		/*
		 * jdk6：  在字符串常量池中创建一个字符串"ab"
		 * jdk7/8：在字符串常量池中没有创建一个字符串"ab"，而是创建一个引用指向new String("ab") 也就是s
		 */
		String s1 = s.intern();

		/*
		 * jdk6：  true false
		 * jdk7/8：true true
		 */
		System.out.println(s == "ab");
		System.out.println(s1 == "ab");
	}

	/**
	 * 用于测试：String#intern练习
	 */
	@Test
	public void test2() {
		String x = "ab";
		String s = new String("a") + new String("b");
		/*
		 * jdk6：  在字符串常量池中存在"ab"，所以返回的是字符串常量池"ab"的地址
		 * jdk7/8：在字符串常量池中存在"ab"，所以返回的是字符串常量池"ab"的地址
		 */
		String s1 = s.intern();

		/*
		 * jdk6：  false true
		 * jdk7/8：false true
		 */
		System.out.println(s == "ab");
		System.out.println(s1 == "ab");
	}

	/**
	 * 用于测试： String#intern练习
	 */
	@Test
	public void test3() {
		String s = new String("ab");
		// String s = new String("a") + new String("b");
		s.intern();
		String s1 = "ab";
		System.out.println(s1 == s);
	}


}
