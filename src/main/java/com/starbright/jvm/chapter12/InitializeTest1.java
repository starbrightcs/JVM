package com.starbright.jvm.chapter12;

/**
 * @description: 哪些场景下不会自动生成<clinit>()方法
 * @author: Star Bright
 * @date: 2024/8/19 11:51
 */
public class InitializeTest1 {

	// 场景一：对应非静态的字段，不管是否已经显式的赋值，都不会生成<clinit>()方法
	public int num = 1;
	// 场景二：静态的字段没有显式的赋值，也不会生成<clinit>()方法
	public static int num1;
	// 场景三：比如对于声明为static final的基本类型的字段，不管是否已经显式的赋值，都不会生成<clinit>()方法，对应的在链接阶段的准备环节进行显式赋值啦
	public static final int num2 = 2;


}
