package com.lkp.leetcode.recursion;

/**
 *@className PalindromeNum
 *@description 回文数
 *@Auther 85291173@qq.com
 *@Date 2019/6/12 9:49
 *@Version
 */
public class PalindromeNum {
	/**
	 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 示例 1:
	 输入: 121
	 输出: true
	 示例 2:
	 输入: -121
	 输出: false
	 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	 示例 3:
	 输入: 10
	 输出: false
	 解释: 从右向左读, 为 01 。因此它不是一个回文数。
	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/palindrome-number
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * 同样的代码go的运行时间和内存 消耗是java的十分之一都不到
	 *
	 *
	 */
	public boolean isPalindrome(int x){
		if(x < 0 || x%10 ==0 && x!= 0){
			return false;
		}
		int k = 0;
		while (x > k){
			k = k*10+x%10;
			x /= 10;
		}
		return k == x || x == k / 10;
	}
	
}
