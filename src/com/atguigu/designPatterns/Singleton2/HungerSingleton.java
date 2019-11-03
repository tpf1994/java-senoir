package com.atguigu.designPatterns.Singleton2;

/**
 * 线程安全的饿汉模式
 * @author DETBG23
 *
 */
public class HungerSingleton {

	private static final HungerSingleton hSingleton = new HungerSingleton();
	
	private HungerSingleton() {
		
	}
	
	public static HungerSingleton getHs() {
		return hSingleton;
	}
	
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println(HungerSingleton.getHs()==HungerSingleton.getHs());
		}).start();
		new Thread(()->{
			System.out.println(HungerSingleton.getHs()==HungerSingleton.getHs());
		}).start();
		new Thread(()->{
			System.out.println(HungerSingleton.getHs()==HungerSingleton.getHs());
		}).start();
	}
}
