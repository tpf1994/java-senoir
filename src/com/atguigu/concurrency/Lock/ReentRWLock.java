package com.atguigu.concurrency.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class Mycache{
	
	private volatile Map<String, Object> map = new HashMap();
//	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock lock = new ReentrantLock();
	public void put(String key,Object val) throws InterruptedException {
//		rwLock.writeLock().lock();
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"正在写入"+key);
			Thread.sleep(300);
			map.put(key, val);
			System.out.println(Thread.currentThread().getName()+"写入完成");
		} finally {
//			rwLock.writeLock().unlock();
			lock.unlock();
		}
	}
	public void get(String key) throws InterruptedException {
//		rwLock.readLock().lock();
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"正在读取"+key);
			Thread.sleep(300);
			map.get(key);
			System.out.println(Thread.currentThread().getName()+"读取完成");
		} finally {
//			rwLock.readLock().unlock();;
			lock.unlock();
		}
	}
	
	public Map<String, Object> getHashMap() {
		return map;
	}
	
}
public class ReentRWLock {

	public static void main(String[] args) throws InterruptedException {
		Mycache mycache = new Mycache();
		for (int i = 0; i < 5; i++) {
			final int temp = i;
			new Thread(()->{
				try {
					mycache.put(temp+"", 0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
		for (int i = 0; i < 5; i++) {
			final int temp = i;
			new Thread(()->{
				try {
					mycache.get(temp+"");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}
}
