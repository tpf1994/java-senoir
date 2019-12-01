package com.atguigu.string;

public class FundamentalType {

	public static void main(String[] args) {
//		Integer a = 127;
//		int d = 128;
//		Integer b = 127;
//		System.out.println(a==d);
//		String a = "a";
//		String b = new String("a");
//		System.out.println(b.intern() == a);
//		Integer c = new Integer(127);
//		System.out.println(a == c);
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01 == i02);
		System.out.println(i01 == i03);
		System.out.println(i03 == i04);
		System.out.println(i02 == i04);
	}
}
