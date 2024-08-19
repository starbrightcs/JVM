package com.starbright.jvm.chapter12;

/**
 * @description: 调用 clinit 方法死锁测试
 * @author: Star Bright
 * @date: 2024/8/19 12:52
 */
class StaticA {
	static {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName("com.starbright.jvm.chapter12.StaticB");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("StaticA init ok");
	}
}

class StaticB {
	static {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			Class.forName("com.starbright.jvm.chapter12.StaticA");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println("StaticB init ok");
	}
}

public class StaticDeadLockMain extends Thread {
	private char flag;

	public StaticDeadLockMain(char flag) {
		this.flag = flag;
		this.setName("Thread-" + flag);
	}

	@Override
	public void run() {
		try {
			Class.forName("com.starbright.jvm.chapter12.Static" + flag);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		System.out.println(getName() + " over");
	}

	public static void main(String[] args) {
		new StaticDeadLockMain('A').start();
		new StaticDeadLockMain('B').start();
	}
}
