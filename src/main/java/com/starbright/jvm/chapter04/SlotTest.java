package com.starbright.jvm.chapter04;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/7/25 11:13
 */
public class SlotTest {

	public static void main(String[] args) {

	}

	public void test1() {
		int a = 1;
	}

	public void test2() {
		double a = 1.0;
		int b = 1;
	}

	public static void test3() {
		int a = 1;
	}

	public void test4() {
		String string = new String();
	}

	public void test5() {
		{
			int a = 1;
		}
		int b = 1;
	}
}
