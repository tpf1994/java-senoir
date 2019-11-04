package com.atguigu.concurrency.Lock;

import java.util.concurrent.TimeUnit;

class Resource implements Runnable{
	private String lock1;
	private String lock2;
	public Resource(String lock1,String lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	@Override
	public void run() {
		synchronized (lock1) {
			System.out.println("�iס��"+lock1+"��Ҫ��lock2");
			try {
				TimeUnit.SECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock2) {
				System.out.println("�iס��"+lock2);
			}
		}
	}
	
	
}
/**
 * ����������֤ ����߳�ͬʱ��ס�����Դ���ͷŵ��µġ�
 * �쳣��������:
 * 	windows���� jps�鿴����pid 
 * 				jstack pid �鿴����ջ��Ϣ
 * @author DETBG23
 *
 */
public class DeadLockDemo {

	public static void main(String[] args) {
		String lock1 = "1";
		String lock2 = "2";
		Resource resource = new Resource("1","2");
		Resource resource2 = new Resource("2","1");
		new Thread(resource).start();
		new Thread(resource2).start();
	}
}
