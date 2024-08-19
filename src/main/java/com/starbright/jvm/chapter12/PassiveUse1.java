package com.starbright.jvm.chapter12;

import org.junit.Test;

/**
 * @description: 关于类的被动使用，也就是不会进行初始化，不会调用 clinit 方法
 * 1. 当访问一个静态字段时，只有真正声明这个字段的类才会被初始化。
 * - 当通过子类引用父类的静态变量，不会导致子类初始化
 * 2. 通过数组定义类引用，不会触发此类的初始化
 * 3. 引用常量不会触发此类或接口的初始化。因为常量在链接阶段就已经被显式赋值了。
 * 4. 调用classLoader类的loadclass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * <p>
 * 说明：没有初始化的类，不代表没有加载
 * <p>
 * VM Arg：-XX:+TraceClassLoading
 * @author: Star Bright
 * @date: 2024/8/19 14:54
 */
public class PassiveUse1 {

	/**
	 * 用于测试：当通过子类引用父类的静态变量，不会导致子类初始化
	 */
	@Test
	public void test1() {
		System.out.println(Child.num);
	}

	/**
	 * 用于测试： 通过数组定义类引用，不会触发此类的初始化
	 */
	@Test
	public void test2() {
		// 只定义了变量，开辟了空间并没有存放对象
		Parent[] arr = new Parent[2];
	}

}

class Parent {
	static {
		System.out.println("Parent.static initializer");
	}

	public static int num = 1;
}

class Child extends Parent {
	static {
		System.out.println("Child.static initializer");
	}
}
