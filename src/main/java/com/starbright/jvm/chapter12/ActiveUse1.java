package com.starbright.jvm.chapter12;

import org.junit.Test;

import java.io.*;

/**
 * @description: 1. 实例化：当创建一个类的实例时，比如使用`new`关键字，或者通过反射、克隆、反序列化。
 * 2. 静态方法：当调用类的静态方法时，即当使用了字节码`invokestatic`指令。
 * @author: Star Bright
 * @date: 2024/8/19 14:08
 */
public class ActiveUse1 {

	/**
	 * 用于测试： 测试new关键字，会触发 clinit 方法
	 */
	@Test
	public void test1() {
		Order order = new Order();
	}

	/**
	 * 用于测试： 序列化
	 */
	@Test
	public void test2() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("order.data"));
			oos.writeObject(new Order());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 用于测试： 反序列化
	 */
	@Test
	public void test3() throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("order.data"));
		Object o = objectInputStream.readObject();
		objectInputStream.close();
	}

	/**
	 * 用于测试： 调用静态方法触发 clinit
	 */
	@Test
	public void test4() {
	    Order.method();
	}

}

class Order implements Serializable {
	static {
		System.out.println("Order.static initializer");
	}

	public static void method() {
		System.out.println("Order.method");
	}
}
