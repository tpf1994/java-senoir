package com.atguigu.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 手写阻塞队列
 * @author DETBG23
 *
 */
public class HandByQueue {

	 //队列容器
    private List<Integer> container = new ArrayList<>();
    private volatile int size;
    private volatile int capacity;
    private Lock lock = new ReentrantLock();
    //Condition
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    HandByQueue(int cap) {
        this.capacity = cap;
    }

    /**
     * 添加方法
     *
     * @param data
     */
    public void add(int data) {
        try {
            lock.lock();
            try {
                while (size >= capacity) {
                    System.out.println("阻塞队列满了");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 取出元素
     *
     * @return
     */
    public int take() {
        try {

            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("阻塞队列空了");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }
	
}
