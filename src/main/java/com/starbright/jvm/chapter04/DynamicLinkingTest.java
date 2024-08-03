package com.starbright.jvm.chapter04;

/**
 * @description: 动态链接测试（动态链接也称之为指向运行时常量池方法的引用）
 * <p>
 *     在Java中，动态链接可以发生在运行时或者加载时，在运行时的话也就是动态绑定，加载时的话就是静态绑定。
 *      <br>
 *     在 Java 源文件被编译到字节码文件中时，所有的变量和方法引用都作为符号引用（Symbolic Reference）保存在 class 文件的常量池里。
 *     比如：描述一个方法调用了另外的其他方法时，就是通过常量池中指向方法的符号引用来表示的，
 *     那么动态链接的作用就是为了将这些符号引用转换为调用方法的直接引用。
 * </p>
 * @author: Star Bright
 * @date: 2024/7/26 11:15
 */
public class DynamicLinkingTest {

	int num = 10;

	public void mehtod1(){
		System.out.println("DynamicLinkingTest.mehtod1");
	}

	public void mehtod2(){
		System.out.println("DynamicLinkingTest.mehtod2");
		mehtod1();
		num++;
	}

}
