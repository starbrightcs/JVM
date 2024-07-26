package com.starbright.jvm.chapter02;

/**
 * @description: 虚拟机必须保证一个类的 <clinit>() 方法在多线程下被同步加锁。
 * @author: Star Bright
 * @date: 2024/7/20 12:16
 */
public class DeadTest {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			System.out.println(Thread.currentThread().getName() + "开始");
			Task task = new Task();
			System.out.println(Thread.currentThread().getName() + "结束");
		};

		Thread thread1 = new Thread(runnable, "线程1");
		Thread thread2 = new Thread(runnable, "线程2");
		thread1.start();
		thread2.start();
	}
}

class Task {
	static {
		if (true) {
			System.out.println(Thread.currentThread().getName() + "初始化当前类");
			while (true) {
				// 模拟死循环
			}
		}
	}
}
