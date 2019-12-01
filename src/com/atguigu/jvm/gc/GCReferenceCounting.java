package com.atguigu.jvm.gc;

public class GCReferenceCounting {

	public Object instance = null;
	// ռ���ڴ��Ա�������
	private static final  int _1m = 1024*1024;
	private byte[] size = new byte[2*_1m]; 
	
	public static void main(String[] args) {
		GCReferenceCounting refA = new GCReferenceCounting();
		GCReferenceCounting refB = new GCReferenceCounting();
		refA.instance = refB;
		refB.instance = refA;
		
		refA = null;
		refB = null;
		System.gc();
	} 
}
