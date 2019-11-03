package com.atguigu.concurrency.threadCommunication;


class AirConditioner {
	private int num = 0;
	public synchronized void incre() throws InterruptedException {
		while (num != 0) {
			this.wait();
		}
		System.out.println(Thread.currentThread().getName() + "当前空调温度" + (++num));
		this.notifyAll();
	}

	public synchronized void decre() throws InterruptedException {
		while (num == 0) {
			this.wait();
		}
		System.out.println(Thread.currentThread().getName() + "当前空调温度" + (--num));
		this.notifyAll();
	}
}

/**
 * 线程间通信，消费者生产者案例。一个给空调升一度，一个减一度,循环10次
 * 
 * @author DETBG23
 *
 */
public class ProducerAndConsumer {
	public static void main(String[] args) {
		AirConditioner airConditioner = new AirConditioner();
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
