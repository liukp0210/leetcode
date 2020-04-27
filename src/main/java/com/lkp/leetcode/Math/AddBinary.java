package com.lkp.leetcode.Math;

/**
 *@className AddBinary
 *@description 67 二进制求和
 *@Auther 85291173@qq.com
 *@Date 2020/4/21 16:43
 *@Version
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		int aLength = a.length() - 1;
		int bLength = b.length() - 1;
		StringBuilder stringBuilder = new StringBuilder();
		//是否进位
		int flag = 0;
		while (aLength >= 0 || bLength >= 0){
			int aInt = 0;
			int bInt = 0 ;
			if(aLength >= 0){
				aInt = a.charAt(aLength) - '0';
				aLength--;
			}
			if(bLength >= 0){
				bInt = b.charAt(bLength) - '0';
				bLength--;
			}
			switch (aInt+bInt + flag){
				case 3:
					stringBuilder.append(1);
					flag = 1;
					break;
				case 2:
					stringBuilder.append(0);
					flag = 1;
					break;
				case 1:
					stringBuilder.append(1);
					flag = 0;
					break;
				case 0:
					stringBuilder.append(0);
					break;
			}
		}
		if(flag>0){
			stringBuilder.append(1);
		}
		return stringBuilder.reverse().toString();
	}
}
