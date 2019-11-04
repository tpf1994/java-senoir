package com.atguigu.concurrency.juc.tool;

import java.util.concurrent.CountDownLatch;

import com.atguigu.common.CountryEnum;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(5);
		for (int i = 1; i <= 5; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"国，被灭");
				countDownLatch.countDown();
			},CountryEnum.getEnum(i).getMsg()).start();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(Thread.currentThread().getName()+"秦帝国一统天下");
	}
}

