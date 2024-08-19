package com.starbright.jvm.chapter12;

import java.util.Random;

/**
 * @description: 使用static+final修饰的字段进行显示赋值的操作，到底是在哪个阶段进行赋值
 * 情况一：链接阶段的准备环节
 * 情况二：在初始化阶段<clinit>()方法赋值
 * 结论:
 * <p>
 * 在链接阶段的准备环节赋值的情况:
 * <p>
 * 1. 对于基本数据类型的字段来说，如果使用static final修饰，则显式赋值(直接赋值常量，而非调用方法)通常是在链接阶段的准备环节进行
 * 2. 对于string米说，如果使用字面量的方式赋值，使用static final修饰的话，则显式赋值通常是在链接阶段的准备环节进行
 * <p>
 * 在初始化阶段`<clinit>()`中赋值的情况:
 * 排除上述的在准备环节赋值的情况之外的情况。
 * @author: Star Bright
 * @date: 2024/8/19 11:58
 */
public class InitializeTest2 {

	public static int a = 1; // 在初始化阶段<clinit>()方法赋值
	public static final int INT_CONSTANT = 10; // 链接阶段的准备环节

	public static final Integer INTEGER_CONSTANT1 = Integer.valueOf(100); // 在初始化阶段<clinit>()方法赋值
	public static Integer INTEGER_CONSTANT2 = Integer.valueOf(1000); // 在初始化阶段<clinit>()方法赋值

	public static final String s0 = "Hello World0"; // // 链接阶段的准备环节
	public static final String s1 = new String("Hello World1"); // // 在初始化阶段<clinit>()方法赋值

	public static final int NUM = new Random().nextInt(100);

}
