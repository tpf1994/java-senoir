package com.atguigu.designPatterns.Singleton2;

public class LazySingletonSafe {

	private static LazySingletonSafe lazySingleton;
	private LazySingletonSafe() {
		
	}
	public synchronized static LazySingletonSafe getLazySingleton() {
		if(lazySingleton==null) {
			lazySingleton = new LazySingletonSafe();
		}
		return lazySingleton;
	}
	
	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		boolean flag = false;
		for(int i = 0;i<100;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+LazySingletonSafe.getLazySingleton());
			},String.valueOf(i)).start();
		}
		Long end = System.currentTimeMillis();
			System.out.println(end-start);
	
	}
}
