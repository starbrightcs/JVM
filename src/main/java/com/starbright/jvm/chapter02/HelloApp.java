package com.starbright.jvm.chapter02;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/7/20 10:59
 */
public class HelloApp {
	/**
	 * 在prepare阶段只会赋值为初始值0
	 * 初始化阶段：a才会被赋值为3
	 */
	public static int a = 3;

	/**
	 * 针对于final字段的数据，在prepare阶段就会显示的赋值，b=3
	 */
	public static final int b = 3;

	public static void main(String[] args) {
		System.out.println(a);
	}
}
