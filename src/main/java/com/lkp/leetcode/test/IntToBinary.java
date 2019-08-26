package com.lkp.leetcode.test;

/**
 *@className IntToBinary
 *@description 数字转二进制 显示
 *@Auther 85291173@qq.com
 *@Date 2019/7/19 17:04
 *@Version
 */
 public class IntToBinary {
	
	/**
	 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
	 示例 1：
	 输入：0000 0000 0000 0000 0000 0000 0000 1011
	 输出：3
	 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
	 示例 2：
	 输入：00000000000000000000000010000000
	 输出：1
	 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
	 示例 3：
	 输入：11111111111111111111111111111101
	 输出：31
	 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
	 *
	 *
	 */
	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int total = 0 ;
		String s = intToBinary(n);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '1'){
				total++;
			}
		}
		
		return   total;
	}
	
	/**
	 *
	 * @param num  要转换的数字
	 * @return
	 */
	public static String intToBinary(int num ){
		String s = Integer.toBinaryString(num);
		int i = 32 - s.length();
		String suff = "";
		for (int j = 0; j < i; j++) {
			suff += 0;
		}
		return  suff + s;
	}
	
	/**
	 * & 与运算 比较两个二进制为 相同为1 不同为0
	 * | 或运算 比较两个数二进制位，只要有一个为1，则为1
	 * ^ 异或运算 比较两个数的二进制位，不同为1 相同为0
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(hammingWeight(-3));
//		System.out.println(hammingWeight2(-3));
		System.out.println(7&6);
	}
	
	public static int hammingWeight2(int n){
		int total = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if((n&mask) != 0){
				total++;
			}
			mask <<= 1;
		}
		
		return total;
	}
	
	public static  int hammingWeight3(int n){
		int total = 0;
		while (n != 0 ){
			total++;
			n &= (n-1);
		}
		return total;
	}
}
