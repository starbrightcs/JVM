package com.starbright.jvm.chapter03;

/**
 * @description: 栈帧测试
 * @author: Star Bright
 * @date: 2024/7/23 17:13
 */
public class StackFrameTest {

	public static void main(String[] args) {
		StackFrameTest stackFrameTest = new StackFrameTest();
		stackFrameTest.methodA();
		System.out.println("StackFrameTest main end");
	}

	public void methodA() {
		System.out.println("StackFrameTest.methodA before");
		methodB();
		System.out.println("StackFrameTest.methodA end");

	}

	public int methodB() {
		System.out.println("StackFrameTest.methodB before");
		int a = 10;
		methodC();
		System.out.println("StackFrameTest.methodB end");
		return a;
	}

	public double methodC() {
		System.out.println("StackFrameTest.methodC before");
		double d = 10.0D;
		System.out.println("StackFrameTest.methodC end");
		return d;
	}

}
