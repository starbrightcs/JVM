package com.starbright.jvm.chapter11;

import java.util.ArrayList;

/**
 * VM Args：-XX:+PrintCommandLineFlags 打印命令行参数
 * -XX:UseSerialGC 表明新生代使用 SerialGC、老年代使用 SerialOldGC
 */
public class GCUseTest {

	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
