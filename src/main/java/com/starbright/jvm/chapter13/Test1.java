package com.starbright.jvm.chapter13;

import org.junit.Test;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/19 17:59
 */
public class Test1 extends ClassLoader {

	/**
	 * 用于测试：数组的类加载器
	 * 关于数组类的加载器和数组元素的类型的类加载器一致；基本数据类型不需要类加载器
	 */
	@Test
	public void test1() {
		String[] strArr = new String[6];
		System.out.println(strArr.getClass().getClassLoader());// 运行结果：null
		ClassLoaderTest[] test = new ClassLoaderTest[1];
		System.out.println(test.getClass().getClassLoader());// 运行结果：sun．misc．Launcher＄AppCLassLoader＠18b4aac2
		int[] ints = new int[2];
		System.out.println(ints.getClass().getClassLoader());// 运行结果：null
	}


}
