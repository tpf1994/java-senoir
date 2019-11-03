package com.atguigu.concurrency.jmm;

/**
 * Java并发编程实战 p28
 * 内存不可见性验证 案例
 * @author DETBG23
 *
 */
public class NotVisibility {

	private static volatile Boolean ready;
	private static int num;
	
	public static void main(String[] args) {
		
		new Thread(()->{
			while(!ready) {
				Thread.yield();
				System.out.println(11);
			}
		}).start();
		
		num = 42;
		ready = true;
		System.out.println("...");
	}
}
