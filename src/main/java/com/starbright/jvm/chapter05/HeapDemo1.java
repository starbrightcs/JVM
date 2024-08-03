package com.starbright.jvm.chapter05;

/**
 * @description: -Xms10m -Xmx10m
 * @author: Star Bright
 * @date: 2024/8/2 15:38
 */
public class HeapDemo1 {

	public static void main(String[] args) {
		System.out.println("main method start");

		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("main method end");
	}

}
