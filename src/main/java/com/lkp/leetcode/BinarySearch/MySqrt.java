package com.lkp.leetcode.BinarySearch;

import java.util.WeakHashMap;

/**
 *@className MySqrt
 *@description X 的平方跟
 *@Auther 85291173@qq.com
 *@Date 2019/8/27 11:21
 *@Version
 */
public class MySqrt {
	
	/**
	 * Implement int sqrt(int x).
	 * Compute and return thr square root of x,where x is guaranteed to be a non-negative integer.
	 * Since the return type is an integer ,the decimal digits are truncated and only the integer part of the result is returned.
	 *Example 1:
	 
	 Input: 4
	 Output: 2
	 Example 2:
	 
	 Input: 8
	 Output: 2
	 Explanation: The square root of 8 is 2.82842..., and since
	              the decimal part is truncated, 2 is returned.
	 *分析：
	 *
	 *  x 的平方根，一定小于 x/2的平方
	 */
	public static int mySqrt(int x) {
		if( 0 == x ){
			return 0;
		}
		long left = 0;
		// 如果x 为1的时候需要加1
		long right = (x>>1)+1;
		while (left <= right){
			long mid = (left+right) >>> 1;
			if(mid*mid == x){
				return (int) mid;
			}else if(mid*mid > x){
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return (int) right;
	}
	
	public static int mySqrt2(int x) {
		if(x == 0 ){
			return 0;
		}
		long left = 0 ;
		//如果x = 1时 需要加1
		long right = (x>>>1)+1;
		while (left <= right){
			long mid = (left+right)>>>1;
			//使用long类型是为了保证 mid*mid没有超出int类型溢出
			if(mid*mid == x){
				return (int) mid;
			}else if(mid*mid > x){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return (int) right;
	}
	public static void main(String[] args) {
		System.out.println(mySqrt2(2147395599));
	}
}
