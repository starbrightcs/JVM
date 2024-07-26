package com.starbright.jvm.chapter02;

/**
 * @description: 类初始化测试
 * @author: Star Bright
 * @date: 2024/7/20 11:13
 */
public class ClassInitTest {
	private static int num = 1;

	static {
		num = 2;
		number = 20;
	}

	private static int number = 10;

	public static void main(String[] args) {
		System.out.println("num = " + num);
		System.out.println("number = " + number);
	}
}
