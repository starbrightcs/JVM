package com.starbright.jvm.chapter13;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/19 16:45
 */
public class UserTest {
	public static void main(String[] args) {
		// 隐式加载
		User user = new User();

		try {
			// 显式加载
			Class.forName("com.starbright.jvm.chapter13.User");

			// 显式加载
			ClassLoader.getSystemClassLoader().loadClass("com.starbright.jvm.chapter13.User");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
