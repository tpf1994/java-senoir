package com.atguigu.concurrency.juc.tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3, false);
		for (int i = 1; i <= 7; i++) {
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"号车抢到车位");
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName()+"号车3秒后离开车位");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			},String.valueOf(i)).start();
		}
	}
}
