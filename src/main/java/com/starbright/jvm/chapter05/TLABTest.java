package com.starbright.jvm.chapter05;

/**
 * @description: 测试 TLAB 参数是否开启，默认情况是开启的，TLAB 只占用Eden的1%
 *  1. jps
 *  2. jinfo -flag UseTLAB pid
 *  3. 结果 -XX:+UseTLAB
 * @author: Star Bright
 * @date: 2024/8/3 15:36
 */
public class TLABTest {

	public static void main(String[] args) {
		System.out.println("TLABTest.main");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
