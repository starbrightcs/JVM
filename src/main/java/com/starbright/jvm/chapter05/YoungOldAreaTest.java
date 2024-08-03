package com.starbright.jvm.chapter05;

/**
 * @description: 大对象直接进入老年代
 * -Xms60M -Xmx60M -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * @author: Star Bright
 * @date: 2024/8/3 15:25
 */
public class YoungOldAreaTest {
	public static void main(String[] args) {
		// 20M
		byte[] buffer = new byte[1024 * 1024 * 20];
	}
}
