package com.lkp.leetcode.recursion;

/**
 *@className UglinessNum
 *@description 丑数
 *@Auther 85291173@qq.com
 *@Date 2019/6/3 14:36
 *@Version
 */
 public class UglinessNum {
	
	/**
	 *
	 * 编写一个程序判断给定的数是否为丑数。
	 丑数就是只包含质因数 2, 3, 5 的正整数。
	 示例 1:
	 输入: 6
	 输出: true
	 解释: 6 = 2 × 3
	 示例 2:
	 输入: 8
	 输出: true
	 解释: 8 = 2 × 2 × 2
	 示例 3:
	 输入: 14
	 输出: false
	 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
	 说明：
	 1 是丑数。
	 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]
	 *
	 */
	public static void main(String[] args) {
		boolean bgly = isBgly(6);
		System.out.println(bgly);
		
	}
	
	
	public static boolean isBgly(int num ){
		if(num == 2 || num == 3 || num == 5 ){
			return true;
		}
		int ugl = num;
		int a = 0 ;
		if(num % 2 ==0 ){
			ugl = num/2;
		}
		if(num%3 == 0){
			ugl = num/3;
		}
		if(num%5 == 0 ){
			ugl = num/5;
		}
		return false;
	}
	
	
	public static boolean isBgly2(int num ){
		if(num <= 0 ){ return  false;}
		while (num %2 ==0 ){
			num /= 2;
		}
		while (num %3 ==0 ){
			num /= 3;
		}
		while (num %5 ==0 ){
			num /= 5;
		}
		
		return num== 1? true :false;
	}
}
