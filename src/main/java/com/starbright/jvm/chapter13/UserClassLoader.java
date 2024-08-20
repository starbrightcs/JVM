package com.starbright.jvm.chapter13;

import java.io.*;

/**
 * @description: 自定义类加载器
 * @author: Star Bright
 * @date: 2024/8/19 16:59
 */
public class UserClassLoader extends ClassLoader {
	private final String rootDir;

	public UserClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}


	/**
	 * 编写findClass的处理逻辑
	 *
	 * @param name 类的全限定名称
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// 获取类的class文件字节数组
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException(name);
		} else {
			// 直接生成class对象
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * 根据类名称返回class文件字节数组
	 *
	 * @param className 类名称
	 * @return class文件字节数组
	 */
	private byte[] getClassData(String className) {
		// 读取类文件的字节
		String path = classNameToPath(className);
		try {
			FileInputStream ins = new FileInputStream(path);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			// 读取类文件的字节码
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 类文件的完全路径
	 *
	 * @param className 类名称
	 * @return 类文件的完全路径
	 */
	private String classNameToPath(String className) {
		return rootDir + File.separator + className.replace('.', '/') + ".class";
	}

	public static void main(String[] args) {
		String rootDir = "/Users/baiyi/github/jvm/src/main/java/";
		try {
			UserClassLoader userClassLoader1 = new UserClassLoader(rootDir);
			Class<?> clazz1 = userClassLoader1.findClass("com.starbright.jvm.chapter13.User");

			UserClassLoader userClassLoader2 = new UserClassLoader(rootDir);
			Class<?> clazz2 = userClassLoader2.findClass("com.starbright.jvm.chapter13.User");

			// clazz1 和 clazz2 对应了不同的类模板结构
			System.out.println(clazz1 == clazz2);
			System.out.println(clazz1.getClassLoader());
			System.out.println(clazz2.getClassLoader());

			// ================ 以前的使用方式 ======================
			// 注意的是：这里加载的是 target 目录下的 User.class 文件，而不是 com/starbright/jvm/chapter13 目录下的 User.class
			Class<?> clazz3 = ClassLoader.getSystemClassLoader().loadClass("com.starbright.jvm.chapter13.User");
			System.out.println(clazz3.getClassLoader());

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
