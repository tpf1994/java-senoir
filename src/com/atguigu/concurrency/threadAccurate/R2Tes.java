package com.atguigu.concurrency.threadAccurate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class R2 {

	private int num = 0;
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();

	public void printA() throws InterruptedException {
		lock.lock();
		try {
			while (num != 0) {
				condition1.await();
			}
			num=1;
			System.out.println(Thread.currentThread().getName() + "A");
			condition2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void printB() throws InterruptedException {
		lock.lock();
		try {
			while (num != 1) {
				condition2.await();
			}
			num=2;
			System.out.println(Thread.currentThread().getName() + "B");
			condition3.signal();
		} finally {
			lock.unlock();
		}
	}

	public void printC() throws InterruptedException {
		lock.lock();
		try {
			while (num != 2) {
				condition3.await();
			}
			num=0;
			System.out.println(Thread.currentThread().getName() + "C");
			condition1.signal();
		} finally {
			lock.unlock();
		}
	}

}

public class R2Tes {

	public static void main(String[] args) {
		R2 r = new R2();
		new Thread(() -> {
			try {
				for (int j = 0; j < 10; j++) {
					r.printA();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "A").start();
		new Thread(() -> {
			try {
				for (int j = 0; j < 10; j++) {
					r.printB();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "B").start();
		new Thread(() -> {
			try {
				for (int j = 0; j < 10; j++) {
					r.printC();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "C").start();
	}

}
