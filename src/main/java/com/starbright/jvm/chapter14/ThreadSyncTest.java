package com.starbright.jvm.chapter14;

/**
 * @description: 线程同步问题
 * @author: Star Bright
 * @date: 2024/8/22 09:51
 */
public class ThreadSyncTest {
	public static void main(String[] args) {
		Number number = new Number();
		new Thread(number, "线程1").start();
		new Thread(number, "线程2").start();
	}
}

class Number implements Runnable {
	private int number = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (number <= 100) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				} else {
					break;
				}

				System.out.println(Thread.currentThread().getName() + ": " + number);
				number++;
			}
		}
	}
}
