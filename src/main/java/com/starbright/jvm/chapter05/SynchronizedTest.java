package com.starbright.jvm.chapter05;

/**
 * 同步省略说明
 * 注意：字节码文件中并没有进行优化，可以看到加锁和释放锁的操作依然存在，同步省略操作是在解释运行时发生的
 */
public class SynchronizedTest {

	public void f() {
		Object hellis = new Object();
		synchronized (hellis) {
			System.out.println(hellis);
		}
	}

}
