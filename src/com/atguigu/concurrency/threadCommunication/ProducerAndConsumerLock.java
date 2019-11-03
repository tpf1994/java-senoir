package com.atguigu.concurrency.threadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditionerS{
	private int num = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	public void incre() throws InterruptedException {
		lock.lock();
		try {
			while (num != 0) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "当前空调温度" + (++num));
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void decre() throws InterruptedException {
		lock.lock();
		try {
			while (num == 0) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "当前空调温度" + (--num));
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}

/**
 * 线程间通信，消费者生产者案例。一个给空调升一度，一个减一度,循环10次
 * 解決虛假唤醒，while()
 * @author DETBG23
 *
 */
public class ProducerAndConsumerLock {
	public static void main(String[] args) {
		AirConditionerS airConditioner = new AirConditionerS();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airConditioner.incre();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "A").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airConditioner.decre();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "B").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airConditioner.incre();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "C").start();
		
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airConditioner.decre();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "D").start();
	}
}
