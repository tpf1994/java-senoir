package com.atguigu.designPatterns.Singleton;

public class SingletonHungry {

	private static SingletonHungry instance = new SingletonHungry();

	private SingletonHungry() {

	}

	public static SingletonHungry getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		SingletonHungry s = SingletonHungry.getInstance();
		SingletonHungry s2 = SingletonHungry.getInstance();
		System.out.println(s == s2);
	}
}
