package com.atguigu.oom;

public class JVMStackOverFlow {

	private int stackLength = 1;
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JVMStackOverFlow jvmStackOverFlow = new JVMStackOverFlow();
		while (true) {
			jvmStackOverFlow.stackLeak();
		}
	}
}
