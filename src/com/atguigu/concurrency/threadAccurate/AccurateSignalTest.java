package com.atguigu.concurrency.threadAccurate;

/**
 * 精准唤醒测试
 * @author DETBG23
 *
 */
public class AccurateSignalTest {

	public static void main(String[] args) {
		Resource r = new Resource();
		
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					r.print5(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"A").start();
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					r.print10(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"B").start();
		
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					r.print15(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"C").start();
	}
}
