package com.starbright.jvm.chapter04;

/**
 * @description: 解析调用虚方法、非虚方法
 * invokestatic 指令和 invokespecia l指令调用的方法称为非虚方法，其余的（final 修饰的除外）称为虚方法
 * @author: Star Bright
 * @date: 2024/7/26 16:51
 */
public class Son extends Father {

	public Son() {
		super();
	}

	public Son(int age) {
		this();
	}

	// 不是重写的静态方法，因为静态方法不能被重写
	public static void showStatic(String str) {
		System.out.println("Son.showStatic str = " + str);
	}

	private void showPrivate(String str) {
		System.out.println("Son.showPrivate str = " + str);
	}

	public void show() {
		// ====== 非虚方法调用，在解析的时候就已经定下来不会变化 ======
		// invokestatic
		showStatic("Star Bright");
		// invokestatic
		super.showStatic("Good");

		// invokespecial
		showPrivate("Hello");
		// invokestatic
		super.showCommon();

		// invokevirtual，虽然是 invokevirtual，但是我们都知道final是没办法被重写，也就是相当于确定的
		// 假设使用 super.showFinal()，那么就是 invokespecial，已经明确是父类的方法了
		// 所以我们认为final方法，也属于是非虚方法
		showFinal();

		// ====== 虚方法调用，在运行时才会确定 ======
		info();

		// 对于接口，需要在运行的时候才会确定子类是谁
		MethodInterface in = null;
		in.methodA();

	}

	public void info() {
		System.out.println("Son info");
	}

}

class Father {

	public Father() {
		System.out.println("Father constructor");
	}

	public static void showStatic(String str) {
		System.out.println("Father.showStatic str = " + str);
	}

	public final void showFinal() {
		System.out.println("Father.showFinal");
	}

	public void showCommon() {
		showStatic("Father.showCommon");
	}
}

interface MethodInterface {
	public void methodA();
}
