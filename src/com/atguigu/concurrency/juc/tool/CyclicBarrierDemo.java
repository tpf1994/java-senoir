package com.atguigu.concurrency.juc.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
			System.out.println("�ٻ�����������");
		});
		for (int i = 1; i <= 7; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "���������ռ�");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}

	}
}