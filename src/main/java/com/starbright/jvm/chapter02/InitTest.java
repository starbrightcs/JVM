package com.starbright.jvm.chapter02;

/**
 * @description: <init> 方法测试</init>
 * @author: Star Bright
 * @date: 2024/7/20 11:59
 */
public class InitTest {
	int a = 1;

	/**
	 * 重写构造方法，默认情况不显示构造方法，则生成一个默认的构造方法
	 */
	public InitTest() {
		a = 20;
		int d = 10;
	}

	public static void main(String[] args) {
		int c = 10;
	}
}
