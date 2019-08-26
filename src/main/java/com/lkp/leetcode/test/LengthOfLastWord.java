package com.lkp.leetcode.test;

/**
 *@className LengthOfLastWord
 *@description 最后一个单词的长度
 *@Auther 85291173@qq.com
 *@Date 2019/7/29 11:30
 *@Version
 */
 public class LengthOfLastWord {
	/**
	 *
	 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
	 如果不存在最后一个单词，请返回 0 。
	 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
	 示例:
	 输入: "Hello World"
	 输出: 5
	 *
	 */
	public static int lengthOfLastWord(String s) {
		String[] split = s.split(" ");
		int length = split.length;
		if(length > 0){
			return split[length - 1].length();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String str = "Hello World";
		int i = lengthOfLastWord(str);
		System.out.println(i);
	}
}
