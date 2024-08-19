package com.starbright.jvm.chapter12;

import org.junit.Test;

import java.util.Random;

/**
 * @description: 4. 当使用`java.lang.reflect`包中的方法反射类的方法时。比如:`Class.forName("com.starbright.java.Test”)`
 * 5. 当初始化子类时，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 * 6. 如果一个接口定义了`default`方法，那么直接实现或者间接实现该接口的类的初始化，该接口要在其之前被初始化
 * 7. 当虚拟机启动时，用户需要指定一个要执行的主类(包含`main()`方法的那个类)，虚拟机会先初始化这个主类。
 * 8. 当初次调用 `MethodHandle`实例时，初始化该 `MethodHandle` 指向的方法所在的类。(涉及解析`REF_getstatic`、`REF_putstatic`、`REF_invokestatic`方法句柄对应的类)
 * <p>
 * 针对 5，补充说明:
 * <p>
 * 当 Java 虚拟机初始化一个类时，要求它的所有父类都已经被初始化，但是这条规则并不适用于接口。
 * <p>
 * - 在初始化一个类时，并不会先初始化它所实现的接口
 * - 在初始化一个接口时，并不会先初始化它的父接口
 * <p>
 * 因此，一个父接口并不会因为它的子接口或者实现类的初始化而初始化。只有当程序首次使用特定接口的静态字段时，才会导致该接口的初始化。
 * @author: Star Bright
 * @date: 2024/8/19 14:28
 */
public class ActiveUse3 {

	static {
		System.out.println("ActiveUse3.static initializer");
	}

	/**
	 * 用于测试： class.forName 加载类的时候触发 clinit 方法
	 */
	@Test
	public void test1() {
		try {
			Class.forName("com.starbright.jvm.chapter12.Order");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 用于测试： 子类初始化的时候，父类需要先进行初始化 可以使用参数 -XX:+TraceClassLoading 打印对应的类加载信息
	 */
	@Test
	public void test2() {
		new Son();
	}

	/**
	 * 用于测试：在初始化一个接口时，并不会先初始化它的父接口
	 */
	@Test
	public void test3() {
		System.out.println(CompareC.num);
	}

	/**
	 * 用于测试：如果一个接口定义了`default`方法，那么直接实现或者间接实现该接口的类的初始化，该接口要在其之前被初始化
	 */
	@Test
	public void test4() {
		new Son();
	}

	public static void main(String[] args) {
		// 当虚拟机启动时，用户需要指定一个要执行的主类(包含`main()`方法的那个类)，虚拟机会先初始化这个主类。
		System.out.println("ActiveUse3.main");
	}

}

class Father {
	static {
		System.out.println("Father.static initializer");
	}
}

class Son extends Father implements CompareB {
	static {
		System.out.println("Son.static initializer");
	}
}

interface CompareB {
	public static final Thread t = new Thread() {
		{
			System.out.println("CompareB.instance initializer");
		}
	};

	public default void method() {
		System.out.println("CompareB.method");
	}
}

interface CompareC extends CompareB {
	public static final Thread t1 = new Thread() {
		{
			System.out.println("CompareC.instance initializer");
		}
	};

	// 触发类的初始化
	public static final int num = new Random().nextInt();

}
