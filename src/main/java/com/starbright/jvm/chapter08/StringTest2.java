package com.starbright.jvm.chapter08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @description: string练习
 * @author: Star Bright
 * @date: 2024/8/12 14:17
 */
public class StringTest2 {

	String str = "good";
	char[] ch = {'t', 'e', 's', 't'};

	public void change(String str, char[] ch) {
		str = "test ok";
		ch[0] = 'b';
	}

	public static void main(String[] args) {
		StringTest2 test = new StringTest2();
		test.change(test.str, test.ch);
		// good
		System.out.println("test.str = " + test.str);
		// best
		System.out.println("test.ch = " + Arrays.toString(test.ch));
	}
}
