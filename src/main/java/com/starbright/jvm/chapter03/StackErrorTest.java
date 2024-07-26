package com.starbright.jvm.chapter03;

/**
 * @description: 栈溢出测试 -Xss1024k 设置栈大小为1024k
 * @author: Star Bright
 * @date: 2024/7/23 17:17
 */
public class StackErrorTest {
	private static int counter = 1;

	public static void main(String[] args) {
		counter++;
		System.out.println(counter);
		main(args);
	}
}
