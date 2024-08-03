package com.starbright.jvm.chapter05;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * @description: -Xms600m -Xmx600m -XX:+PrintGCDetails
 * @author: Star Bright
 * @date: 2024/8/2 18:03
 */
public class OomTest {
	public static void main(String[] args) {
		ArrayList<Picture> pictures = new ArrayList<>();
		while (true) {
			pictures.add(new Picture(new byte[1024 * 1024]));
		}
	}
}

@AllArgsConstructor
class Picture {
	private byte[] pixels;
}
