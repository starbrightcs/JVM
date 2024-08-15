package com.starbright.jvm.chapter10;

/**
 * 参数：-XX:+PrintGCDetails
 */
public class LocalVarGC {
	public void localvarGC1() {
		byte[] buffer = new byte[10 * 1024 * 1024];
		System.gc();
	}

	public void localvarGC2() {
		byte[] buffer = new byte[10 * 1024 * 1024];
		buffer = null;
		System.gc();
	}

	public void localvarGC3() {
		{
			byte[] buffer = new byte[10 * 1024 * 1024];
		}
		System.gc();
	}

	public void localvarGC4() {
		{
			byte[] buffer = new byte[10 * 1024 * 1024];
		}
		int value = 10;
		System.gc();
	}

	public void localvarGC5() {
		localvarGC1();
		System.gc();
	}

	public static void main(String[] args) {
		LocalVarGC local = new LocalVarGC();
		local.localvarGC1();
	}
}
