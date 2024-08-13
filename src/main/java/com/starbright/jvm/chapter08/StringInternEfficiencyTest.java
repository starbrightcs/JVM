package com.starbright.jvm.chapter08;

/**
 * @description: String#intern效率测试，主要是在空间使用上的
 * 在开发中如果有大量重复的字符串，可以使用intern，可以节省大量空间
 * @author: Star Bright
 * @date: 2024/8/13 15:25
 */
public class StringInternEfficiencyTest {
	public static final int MAX_COUNT = 1000 * 10000;
	protected static final String[] ARR = new String[MAX_COUNT];

	public static void main(String[] args) {
		Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.currentTimeMillis();
		for (int i = 0; i < MAX_COUNT; i++) {
			// ARR[i] = String.valueOf(data[i % data.length]);
			ARR[i] = String.valueOf(data[i % data.length]).intern();
		}

		System.out.printf("cost: %d ms\n", System.currentTimeMillis() - start);

		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
