package com.atguigu.designPatterns.Singleton;

/**
 * 懒汉模式
 * 
 * @author DETBG23
 *
 */
public class SingletonLazyNotSafe {

	private static SingletonLazyNotSafe instance;

	private SingletonLazyNotSafe() {

	}

	public static SingletonLazyNotSafe getInstance() {
		if (instance == null) {
			instance = new SingletonLazyNotSafe();
		}
		return instance;
	}

	public static void main(String[] args) {
		SingletonLazyNotSafe l = SingletonLazyNotSafe.getInstance();
		SingletonLazyNotSafe l2 = SingletonLazyNotSafe.getInstance();
		System.out.println(l == l2);
		System.out.println(l);
		System.out.println(l2);
	}
}
