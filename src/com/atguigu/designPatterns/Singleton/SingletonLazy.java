package com.atguigu.designPatterns.Singleton;

/**
 * 懒汉模式
 * @author DETBG23
 *
 */
public class SingletonLazy {

	private volatile static SingletonLazy instance;
	
	private SingletonLazy() {
		
	}
	
	public static SingletonLazy getInstance() {
		if(instance == null) {
			synchronized(SingletonLazy.class) {
				if(instance == null) {
					instance = new  SingletonLazy();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingletonLazy l = SingletonLazy.getInstance();
		SingletonLazy l2 = SingletonLazy.getInstance();
		System.out.println(l==l2);
		System.out.println(l);
		System.out.println(l2);
	}
}
