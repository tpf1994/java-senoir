package com.atguigu.concurrency.threadAccurate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求：A线程打印5次，B线程打印10次,C线程打印15次,总共循环10次
 * 
 * @author DETBG23
 *
 */
public class Resource {

	private int num = 1;// 1：A,2:B,3:C

	Lock lock = new ReentrantLock();

	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();

	public void print5(int a) throws InterruptedException {
		lock.lock();
		try {
			while (num != 1) {
				c1.await();
			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "当前是第" + a + "次打印，数字为--" + i);
			}
			num = 2;
			c2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void print10(int a) throws InterruptedException {
		lock.lock();
		try {
			while (num != 2) {
				c2.await();
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "当前是第" + a + "次打印，数字为--" + i);
			}
			num = 3;
			c3.signal();
		} finally {
			lock.unlock();
		}
	}

	public void print15(int a) throws InterruptedException {
		lock.lock();
		try {
			while (num != 3) {
				c3.await();
			}
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "当前是第" + a + "次打印，数字为--" + i);
			}
			num = 1;
			c1.signal();
		} finally {
			lock.unlock();
		}
	}

}
