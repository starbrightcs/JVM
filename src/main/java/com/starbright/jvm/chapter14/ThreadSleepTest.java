package com.starbright.jvm.chapter14;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/22 09:48
 */
public class ThreadSleepTest {
	public static void main(String[] args) {
		System.out.println("hello-1");
		try {
			Thread.sleep(1000 * 60 * 10);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hello-2");
	}
}
