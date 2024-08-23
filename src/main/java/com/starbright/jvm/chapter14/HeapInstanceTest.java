package com.starbright.jvm.chapter14;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description: -Xms60m -Xmx60m -XX:SurvivorRatio=8
 * @author: Star Bright
 * @date: 2024/8/22 11:10
 */
public class HeapInstanceTest {
	byte[] buffer = new byte[new Random().nextInt(1024 * 100)];

	public static void main(String[] args) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<HeapInstanceTest> list = new ArrayList<>();
		while (true) {
			list.add(new HeapInstanceTest());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
