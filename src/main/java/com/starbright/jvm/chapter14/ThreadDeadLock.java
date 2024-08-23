package com.starbright.jvm.chapter14;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/22 09:38
 */
public class ThreadDeadLock {
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		new Thread(() -> {
			synchronized (s1) {
				s1.append("a");
				s2.append("1");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				synchronized (s2) {
					s1.append("b");
					s2.append("2");

					System.out.println(s1);
					System.out.println(s2);
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (s2) {
				s1.append("c");
				s2.append("3");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

				synchronized (s1) {
					s1.append("d");
					s2.append("4");

					System.out.println(s1);
					System.out.println(s2);
				}
			}
		}).start();
	}
}
