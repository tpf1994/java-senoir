package com.atguigu.concurrency.unsafe;

import sun.misc.Unsafe;

class VO {
	public int a = 0;

	public long b = 0;

	public static String c = "123";

	public static Object d = null;

	public static int e = 100;
}

public class UnsafeDemo {
	public static void main(String[] args) throws Exception {
		Unsafe unsafe = Unsafe.getUnsafe();
		// ��ȡʵ���ֶε�ƫ�Ƶ�ַ,ƫ����С���Ǹ��ֶ�(������ͷ��)���Ƕ���ͷ�Ĵ�С
		System.out.println(unsafe.objectFieldOffset(VO.class.getDeclaredField("a")));
		System.out.println(unsafe.objectFieldOffset(VO.class.getDeclaredField("b")));

		// fieldOffset��objectFieldOffset����һ��,fieldOffset�ǹ�ʱ����,��ò�Ҫ��ʹ��
		System.out.println(unsafe.fieldOffset(VO.class.getDeclaredField("b")));

	}
}
