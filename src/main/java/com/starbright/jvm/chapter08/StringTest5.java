package com.starbright.jvm.chapter08;

public class StringTest5 {
    public static void main(String[] args) {
        System.out.println();// 1230
        System.out.println("1");// 1231
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");// 1240

        // 如下的字符串"1" 到 "10"不会再次加载
        System.out.println("1");// 1241
        System.out.println("2");// 1241
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");// 1241

    }
}
