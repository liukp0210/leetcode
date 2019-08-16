package com.lkp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *@className PlusOne
 *@description 加一
 *@Auther 85291173@qq.com
 *@Date 2019/7/29 11:41
 *@Version
 */
 public class PlusOne {
	/**
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
	 你可以假设除了整数 0 之外，这个整数不会以零开头。
	 示例 1:
	 输入: [1,2,3]
	 输出: [1,2,4]
	 解释: 输入数组表示数字 123。
	 示例 2:
	 输入: [4,3,2,1]
	 输出: [4,3,2,2]
	 解释: 输入数组表示数字 4321。
	 *看着有点复杂，但是是我自己想出来的，没有题解中方法便利，但是思路是一样的 ，希望以后自己也能一次写出简单高效的代码
	 */
	public static int[] plusOne(int[] digits) {
		boolean flag = false;
		for (int i = digits.length-1; i >= 0 ; i--) {
			if(i == digits.length - 1){
				digits[i] = digits[i]+1;
				if(digits[i] >= 10){
					digits[i] = digits[i]%10;
					flag = true;
					continue;
				}
			}
			if(flag){
				digits[i] = digits[i]+1;
				if(digits[i] >= 10){
					digits[i] = digits[i]%10;
					flag = true;
				}else{
					flag = false;
				}
			}
		}
		if(digits[0] == 0){
			int[] digits2 = new int[digits.length+1];
			for (int i = 1; i < digits2.length; i++) {
				digits2[i] = digits[i-1];
			}
			digits2[0] = 1;
			return digits2;
		}
		return digits;
	}
	
	public static int[] plusOne1(int[] digits) {
		for (int i = digits.length-1; i >= 0 ; i--) {
			digits[i]++;
			digits[i] = digits[i]%10;
			if(digits[i] != 0){
				return digits;
			}
		}
		if(digits[0] == 0 ){
			int[] digits2 = new int[digits.length+1];
			digits2[0] = 1;
			return digits2;
		}
		return digits;
	}
	
	public static void main(String[] args) {
	 int[] arr = new int[]{9,9,9,9};
		int[] ints = plusOne1(arr);
		for (int num:ints) {
			System.out.println(num);
			
		}
	}
}
