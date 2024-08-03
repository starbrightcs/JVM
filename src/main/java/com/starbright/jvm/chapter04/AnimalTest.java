package com.starbright.jvm.chapter04;

/**
 * @description: 早期绑定和晚期绑定测试
 * @author: Star Bright
 * @date: 2024/7/26 16:14
 */
public class AnimalTest {

	public void showAnimal(Animal animal) {
		// 表现为晚期绑定
		animal.eat();
	}

	public void showHunting(Hunting hunting) {
		// 表现为晚期绑定，因为接口不能实例化
		hunting.hunt();
	}

}

class Animal {
	public void eat() {
		System.out.println("animal eat");
	}
}

interface Hunting {
	void hunt ();
}

class Dog extends Animal implements Hunting {
	@Override
	public void eat() {
		System.out.println("狗吃骨头");
	}

	@Override
	public void hunt() {
		System.out.println("狗抓耗子，多管闲事");
	}
}

class Cat extends Animal implements Hunting {

	public Cat() {
		// 表现为早期绑定
		super();
	}

	public Cat(String name) {
		// 表现为早期绑定
		this();
	}

	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}
	@Override
	public void hunt() {
		System.out.println("猫抓耗子，天经地义");
	}
}

