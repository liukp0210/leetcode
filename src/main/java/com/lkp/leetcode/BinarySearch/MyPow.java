package com.lkp.leetcode.BinarySearch;

/**
 *@className MyPow
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2020/1/18 9:56
 *@Version
 */
public class MyPow {
	
	/**
	 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
	 示例 1:
	 输入: 2.00000, 10
	 输出: 1024.00000
	 示例 2:
	 输入: 2.10000, 3
	 输出: 9.26100
	 示例 3:
	 输入: 2.00000, -2
	 输出: 0.25000
	 解释: 2-2 = 1/22 = 1/4 = 0.25
	 *
	 *
	 */
	public double myPow2(double x, int n) {
		if(n == 0 ){
			return 1;
		}
		long i = n ;
		if(n < 0 ){
			x = 1/x;
			i = -n;
		}
		double result = x ;
		for (int j = 0; j < i - 1; j++) {
			result *= x;
		}
		return result;
	}
	public double myPow(double x, int n) {
		if(n == 0 ){
			return 1;
		}
		int i = 0 ;
		double result = 0 ;
		if(n > 0){
			result = x;
		}else{
			double test = test(x, Math.abs(n));
			result = 1/test;
			return result;
		}
		result = test(result, n);
		return result;
	}
	public double test(double x, int n ){
		int i = 0 ;
		double result = x;
		while ( i < n - 1){
			  result *= x;
			  i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MyPow myPow = new MyPow();
		double v = myPow.myPow2(2.00000, 10);
		System.out.println(v);
		double pow = Math.pow(0.00001, 2147483647);
		System.out.println(pow);
	}
}
