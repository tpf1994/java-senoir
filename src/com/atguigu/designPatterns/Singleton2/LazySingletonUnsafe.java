package com.atguigu.designPatterns.Singleton2;

public class LazySingletonUnsafe {

	private static LazySingletonUnsafe lazySingleton;
	private LazySingletonUnsafe() {
		
	}
	public  static LazySingletonUnsafe getLazySingleton() {
		if(lazySingleton==null) {
			lazySingleton = new LazySingletonUnsafe();
		}
		return lazySingleton;
	}
	
	public static void main(String[] args) {
		for(int i = 0;i<20;i++) {
			new Thread(()->{
				System.out.println(LazySingletonUnsafe.getLazySingleton());
			}).start();
		}
	
	}
}
