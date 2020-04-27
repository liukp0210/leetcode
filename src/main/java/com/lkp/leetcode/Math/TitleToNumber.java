package com.lkp.leetcode.Math;

/**
 *@className TitleToNumber
 *@description 171 Excel表列序号
 *@Auther 85291173@qq.com
 *@Date 2020/4/22 17:55
 *@Version
 */
public class TitleToNumber {
	public static int titleToNumber(String s) {
		int res = 0;
		//1.循环从高位向低位循环，将每一位+1*26 结果累加
		for (int i = 0; i < s.length() ; i++) {
			char c = s.charAt(i);
			int i1 = c+1 - 'A';
			res *= 26;
			res += i1;
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		int i = titleToNumber("AZ");
		System.out.println(i);
	}
}
