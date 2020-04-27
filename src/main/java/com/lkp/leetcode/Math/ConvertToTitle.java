package com.lkp.leetcode.Math;

/**
 *@className ConvertToTitle
 *@description 168 Excel表列名称
 *@Auther 85291173@qq.com
 *@Date 2020/4/21 17:29
 *@Version
 */
public class ConvertToTitle {
	public String convertToTitle(int n) {
		StringBuilder stringBuilder = new StringBuilder();
		while (n > 0 ){
			n -= 1;
			stringBuilder.append((char) ('A'+ n%26));
			n /= 26;
		}
		return stringBuilder.reverse().toString();
	}
	
	public static void main(String[] args) {
		ConvertToTitle convertToTitle = new ConvertToTitle();
		String s = convertToTitle.convertToTitle(9927);
		System.out.println(s);
	}
}
