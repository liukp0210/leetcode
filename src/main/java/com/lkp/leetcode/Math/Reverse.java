package com.lkp.leetcode.Math;

/**
 *@className Reverse
 *@description 7 整数反转
 *@Auther 85291173@qq.com
 *@Date 2020/4/21 16:33
 *@Version
 */
public class Reverse {
	//判断转化溢出问题
	public static int reverse(int x) {
		if(x == 0 ){
			return 0 ;
		}
		int res = 0 ;
		while (x != 0){
			if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && x%10 > 7)  ||
					res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && x%10 < -8)){
				return 0;
			}
			res *= 10;
			res += x%10;
			x /= 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int reverse = reverse(123);
		System.out.println(reverse);
		System.out.println(-8%10);
	}
}
