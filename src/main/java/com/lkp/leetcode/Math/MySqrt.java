package com.lkp.leetcode.Math;

/**
 *@className MySqrt
 *@description 69 x的平方根
 *@Auther 85291173@qq.com
 *@Date 2020/4/21 17:13
 *@Version
 */
public class MySqrt {
	public int mySqrt(int x) {
		if(x == 1){
			return 1;
		}
		long left = 0 ;
		long right = x/2;
		while (left <= right){
			long mind = (left + right)>>1;
			if(mind * mind == x){
				return (int) mind;
			}else if(mind * mind > x){
				right = mind - 1;
			}else{
				left = mind + 1;
			}
		}
		return (int) right;
	}
	
	public static void main(String[] args) {
		MySqrt mySqrt = new MySqrt();
		int i = mySqrt.mySqrt(2147395599);
		System.out.println(i);
	}
}
