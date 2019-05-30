package com.lkp.leetcode.utils;

/**
 *@className UpsideDownNum
 *@description 颠倒数字
 *@Auther 85291173@qq.com
 *@Date 2019/5/30 14:37
 *@Version
 */
public class UpsideDownNum {
	/**
	 颠倒给定的 32 位无符号整数的二进制位。
	 示例 1：
	 输入: 0000 0010 1001 0100 0001 1110 1001 1100
	 输出: 0011 1001 0111 1000 0010 1001 0100 0000
	 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
	 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
	 示例 2：
	 输入：11111111111111111111111111111101
	 输出：10111111111111111111111111111111
	 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
	 因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
	 提示：
	 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
	 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
	 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
	 
	 研究TM半天不知道里面的原理
	 **/
	public static void main(String[] args) {
		int reverse = Integer.reverse(15);
		System.out.println(reverse);
		// 0000 0000 0000 0000 0000 0000 0000 1111
		int i2 = reverseBits(15);
		//i2 = 1111  0000 0000 0000 0000 0000 0000 0000
		System.out.println(i2);
	}
	
	public static int reverseBits(int n) {
		int a=0;
		for(int i=0;i<=31;i++){
			int i1 = 1 & (n >> i);
			System.out.println("1 & (n >> i) = " + i1);
			System.out.println("((1&(n>>i))<<(31-i) = " + ((1&(n>>i))<<(31-i)));
			a=a+((1&(n>>i))<<(31-i));
		}
		return a;
	}
}
