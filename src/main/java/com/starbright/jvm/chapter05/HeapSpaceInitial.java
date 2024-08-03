package com.starbright.jvm.chapter05;

/**
 * @description:
 * 1. 设置堆空间大小
 *    -xms 用来设置堆空间（年轻代+老年代）初始大小
 *      -X 是JVM的运行参数
 *      ms 是 memory start
 *    -xmx 用来设置堆空间（年轻代+老年代）最大大小
 *
 * 2. 默认堆大小空间
 *    初始内存大小：  物理电脑内存大小 / 64
 *    最大内存大小：  物理电脑内存大小 / 4
 * @author: Star Bright
 * @date: 2024/8/2 15:58
 */
public class HeapSpaceInitial {

	public static void main(String[] args) {

		// 返回Java虚拟机中的堆内存总量
		long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		// 返回Java虚拟机试图使用的最大堆内存
		long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

		System.out.println("-Xms: " + initialMemory + "M");
		System.out.println("-Xmx: " + maxMemory + "M");

		System.out.println("系统内存大小为：" + initialMemory * 64 / 1024 + "G");
		System.out.println("系统内存大小为：" + maxMemory * 4 / 1024 + "G");

		// jps 使用
		/* try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} */

	}
}
