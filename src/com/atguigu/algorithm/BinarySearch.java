package com.atguigu.algorithm;


/**
 * 递归实现二分法排序
 * @author DETBG23
 * @since 2019年12月1日下午7:57:08
 */
public class BinarySearch {

	public static int rank(int key,int[] a) {
		return rank(key, a , 0 , a.length - 1);
	}
	
	public static int rank(int key,int[] a,int lo,int hi) {
		if(lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(key < a[mid]) return rank(key, a,lo,mid-1);
		else if(key > a[mid]) return rank(key, a, mid + 1, hi);
		else return mid;
	}
}
