package com.atguigu.designPatterns.Singleton2;

public class LazySingletonDCL {

	private static volatile LazySingletonDCL lazySingleton;
	private LazySingletonDCL() {
		
	}
	public static LazySingletonDCL getLazySingleton() {
		if(lazySingleton==null) {
			synchronized (LazySingletonDCL.class) {
				if(lazySingleton==null) {
					lazySingleton = new LazySingletonDCL();
				}
			}
		}
		return lazySingleton;
	}
	
	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		for(int i = 0;i<100;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+LazySingletonDCL.getLazySingleton());
			},String.valueOf(i)).start();
		}
		Long end = System.currentTimeMillis();
			System.out.println(end-start);
	
	}
}
