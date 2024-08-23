package com.starbright.jvm.chapter14;

import java.util.ArrayList;

/**
 * @description: -Xms60m -Xmx60m -XX:SurvivorRatio=8
 * @author: Star Bright
 * @date: 2024/8/20 21:26
 */
public class GCTest {
	public static void main(String[] args) {
		ArrayList<byte[]> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(new byte[1024 * 1024]);
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
