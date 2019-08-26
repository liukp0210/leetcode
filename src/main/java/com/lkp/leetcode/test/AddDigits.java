package com.lkp.leetcode.test;

/**
 *@className AddNum
 *@description 各位相加
 *@Auther 85291173@qq.com
 *@Date 2019/6/3 11:14
 *@Version
 */
 public class AddDigits {
	
	/**
	 *
	 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
	 示例:
	 输入: 38
	 输出: 2
	 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
	 进阶:
	 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
	 
	 f(x*10+y)=f(x*9+x+y)=f(x+y)  数学推理方法 数学不好只能看着别人的答案
	 *
	 */
	public static void main(String[] args) {
		
		int i = addDigits(253);
		System.out.println(i);
	}
	
	/**
	 * 1.判断添加的数字是否大于10
	 * 2.如果大于10取得各位数的数字进行相加
	 * 3.递归调用
	 * @param num
	 * @return
	 */
	public static int addDigits(int num){
		if(num <= 9){
			return num;
		}
		int a = num;
		int tatal = 0;
		while (a > 0){
			tatal += a%10;
			a /= 10;
		}
		return addDigits(tatal);
	}
	
	/**
	 * 数学推理   f(x*10+y)=f(x*9+x+y)=f(x+y), 成立当f(x)= x%9
	 * @param num
	 * @return
	 */
	public static int addDigits2(int num){
		if(num > 0){
			return num%9==0?9:num%9;
		}
		return 0;
	}
	
}
