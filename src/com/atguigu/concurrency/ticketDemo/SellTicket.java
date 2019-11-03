package com.atguigu.concurrency.ticketDemo;

class Ticket {

	private int num = 100;
	public synchronized void saleTicket() {
		if(num>=0) {
			System.out.println(Thread.currentThread().getName()+"正在卖第"+(num--)+"票");
		}
	}
}
public class SellTicket{
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(()->{
			for (int i = 0; i < 101; i++) {
				ticket.saleTicket();
			}
		},"A窗口").start();
		
		new Thread(()->{
			for (int i = 0; i < 101; i++) {
				ticket.saleTicket();
			}
		},"B窗口").start();
		
		new Thread(()->{
			for (int i = 0; i < 101; i++) {
				ticket.saleTicket();
			}
		},"C窗口").start();
	}
}