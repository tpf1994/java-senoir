package com.atguigu.designPatterns.proxy4;

public class StaticProxy implements Teacher{

	private Teacher teacher;
	
	public StaticProxy(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public void teach() {
		System.out.println("老師正在来的路上。。");
		teacher.teach();
		System.out.println("讲完课，全体起立");
	}
	
	public static void main(String[] args) {
		Teacher teacher = new Daming();
		StaticProxy sp = new StaticProxy(teacher);
		sp.teach();
	}
}
