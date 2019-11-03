package com.atguigu.designPatterns.proxy2;

public class StaticBookProxy implements Books{

	private Books book;
	
	public StaticBookProxy (Books book) {
		this.book = book;
	}
	
	@Override
	public void read() {
		System.out.println("从网上买书");
		book.read();
		System.out.println("读后感。。。。");
	}
	
	public static void main(String[] args) {
		Books book = new Poor();
		StaticBookProxy proxy = new StaticBookProxy(book);
		proxy.read();
	}
}
