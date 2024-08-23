package com.starbright.jvm.chapter14;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * @description: -Xms600m -Xmx600m -XX:SurvivorRatio=8
 * @author: Star Bright
 * @date: 2024/8/2 18:03
 */
public class OomTest {
	public static void main(String[] args) {
		ArrayList<Picture> pictures = new ArrayList<>();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			pictures.add(new Picture(new byte[100 * 50]));
		}
	}
}

@AllArgsConstructor
class Picture {
	private byte[] pixels;
}
