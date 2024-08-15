package com.starbright.jvm.chapter10;

public class SystemGCTest {
	public static void main(String[] args) {
		new SystemGCTest();
		// 提醒jvm的垃圾回收器执行gc,但是不确定是否马上执行gc
		System.gc();
		// System.gc()与Runtime.getRuntime().gc() 的作用一样。
        // 强制调用失去引用对象的finalize()方法
		System.runFinalization();
	}

	// GC回收之前会调用finalize()方法
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("SystemGCTest 重写了finalize()");
	}
}
