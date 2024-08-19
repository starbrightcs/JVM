package com.starbright.jvm.chapter12;

import org.junit.Test;

import java.util.Random;

/**
 * @description: 静态字段：当使用类、接口的静态字段时（final修饰特殊考虑），比如，使用getstatic或者putstatic指令。（对应访问变量、赋值变量操作）
 * @author: Star Bright
 * @date: 2024/8/19 14:19
 */
public class ActiveUse2 {

	/**
	 * 用于测试：类的变量触发 clinit 方法
	 */
	@Test
	public void test() {
		// System.out.println(User.num1); // 触发
		// System.out.println(User.num2); // 不触发
		System.out.println(User.num3); // 触发
	}

	/**
	 * 用于测试： 测试接口是否触发clinit方法
	 */
	@Test
	public void test2() {
		// System.out.println(CompareA.num); // 不触发
		System.out.println(CompareA.num2); // 触发
	}
}

class User {
	static {
		System.out.println("User.static initializer");
	}

	public static int num1 = 1;
	public static final int num2 = 2;
	public static final int num3 = new Random().nextInt(10);
}

interface CompareA {

	// 巧妙的点在于，如果执行了初始化clinit方法，则会打印 CompareA.run
	public static final Thread t = new Thread() {
		{
			System.out.println("CompareA.instance initializer");
		}
	};

	public static final int num = 1;
	public static final int num2 = new Random().nextInt(10);
}
