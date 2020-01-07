package com.lkp.leetcode.hash;

/**
 *@className NumJewelsInStones
 *@description 771. 宝石与石头
 *@Auther 85291173@qq.com
 *@Date 2020/1/7 9:31
 *@Version
 */
public class NumJewelsInStones {
	
	public int numJewelsInStones(String J, String S) {
		int count = 0;
		char[] chars = J.toCharArray();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			for (int j = 0; j < chars.length; j++) {
				if (chars[i] == c){
					count++;
				}
			}
		}
		return count;
	}
}
