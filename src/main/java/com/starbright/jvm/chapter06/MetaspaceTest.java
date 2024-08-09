package com.starbright.jvm.chapter06;

/**
 * @description: JDK1.8及之后版本：-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @author: Star Bright
 * @date: 2024/8/4 20:13
 */
public class MetaspaceTest {

	public static void main(String[] args) {
		System.out.println("MetaspaceTest.main");

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
