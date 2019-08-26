package com.lkp.leetcode.test;

/**
 *@className TwoPower
 *@description 2的幂
 *@Auther 85291173@qq.com
 *@Date 2019/6/4 17:01
 *@Version
 */
public class TwoPower {
	/**
	 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
	 示例 1:
	 输入: 1
	 输出: true
	 解释: 20 = 1
	 示例 2:
	 输入: 16
	 输出: true
	 解释: 24 = 16
	 示例 3:
	 输入: 218
	 输出: false
	 *
	 */
	
	public static boolean isPowerOfTwo(int n) {
		if(n == 1){
			return true;
		}
		int a = n;
		while (a > 2){
			if(a % 2 ==0){
				a >>= 1;
			}else{
				return false;
			}
		}
		return a == 2 ? true:false;
	}
	
	/**
	 * 在二进制中 n的幂 永远只有一位为1    0001(1),0010(2),0100(4),1000(8)
	 * $使用位与 两个数转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0
	 * 解题： 当n为2的幂时 n-1&n==0;
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo2(int n) {
		return n>0&&(n&(n-1))==0;
	}
	
	public static void main(String[] args) {
		boolean powerOfTwo = isPowerOfTwo(16);
		System.out.println(powerOfTwo);
	}
}
