package com.atguigu.designPatterns.proxy3;

public class StaticProxy implements Notebook{

	private Notebook notebook;
	
	public StaticProxy(Notebook notebook) {
		this.notebook = notebook;
	}
	
	@Override
	public void code() {
		System.out.println("敲代码之前的通知。。。。。");
		notebook.code();
		System.out.println("敲代码之后的通知。。。。。");
	}
	
	public static void main(String[] args) {
		Notebook noteBook = new ThinkPad();
		StaticProxy proxy = new StaticProxy(noteBook);
		proxy.code();
	}
	
}
