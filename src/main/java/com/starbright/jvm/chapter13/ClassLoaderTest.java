package com.starbright.jvm.chapter13;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

/**
 * @description:
 * @author: Star Bright
 * @date: 2024/8/19 17:49
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		System.out.println("========引导类加载器======");
		URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
		for (URL urL : urLs) {
			System.out.println(urL.getPath());
		}

		ClassLoader bootStrapClassLoader = Provider.class.getClassLoader();
		System.out.println("bootStrapClassLoader = " + bootStrapClassLoader);

		System.out.println();
		System.out.println("========扩展类加载器======");
		String extProperty = System.getProperty("java.ext.dirs");
		for (String path : extProperty.split(";")) {
			System.out.println(path);
		}

		ClassLoader extClassLoader = DESKeyFactory.class.getClassLoader();
		System.out.println("extClassLoader = " + extClassLoader);

	}
}
