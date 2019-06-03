package com.lkp.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@className happyNum
 *@description 快乐数
 *@Auther 85291173@qq.com
 *@Date 2019/5/31 9:33
 *@Version
 */
public class happyNum {
	/**
	 *
	 *  编写一个算法来判断一个数是不是“快乐数”。
	 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
	 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
	 示例:
	 输入: 19
	 输出: true
	 解释:
	 1*1 + 9*9 = 82
	 8*8 + 2*2 = 68
	 6*6 + 8*8 = 100
	 1*1 + 0*0 + 0*0 = 1
	 *
	 */
	
	
	/**
	 * 自己写的
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		if(n == 1){
			return true;
		}
		int total = n;
		while (total != 1){
			int[] ints = splitNum(total);
			total = totalNum(ints);
			if(!containsNum(total)){
				return false;
			}
		}
		if(total == 1){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断平方和是否是下列数中的一个
	 * @param num
	 * @return
	 */
	public static boolean containsNum( int num){
		int[] noHappyArr = new int[]{ 4,16,37,58,89,145,42,20 };
		for (int i:noHappyArr) {
			if(num == i){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 求分割后的数的平方和
	 * @param ints
	 * @return
	 */
	public static int totalNum(int[] ints){
		int total = 0;
		for (int i = 0; i < ints.length; i++) {
			total += ints[i] * ints[i];
		}
		return total;
	}
	
	/**
	 *分割数字
	 * @param num
	 * @return
	 */
	public static int[] splitNum(int num){
		if(num <= 0){
			return null;
		}
		int[] arr = new int[(num+"").length()];
		int a = num;
		for (int i = 0; i < (num+"").length(); i++) {
			arr[i] = a % 10;
			a = a/10;
		}
		return arr;
	}
	
	
	/**
	 * 参考网上的
	 *
	 */
	
	public static void main(String[] args) {
		/**
		 * 1.分割数字
		 * 2.将分割的数字平方并且相加(如果相加的数==1表示为欢乐数)
		 * 3.如果不是快乐数的时候循环会进入到4,16,37,58,89,145,42,20 这些数中；所以添加判断如果平方和为这些数的其中一个
		 * 则直接返回false;
		 */
		System.out.println(isHappy1(2));
	}
	
	
	
	static List<Integer> nums = new ArrayList<>();
	
	public static boolean isHappy1(int n) {
		
		if(nums.contains(n)){
			return false;
		}
		nums.add(n);
		int sum = 0;
		while(n/10!=0){ //两位数
			int unit = n - (n/10)*10;
			sum += (int)Math.pow(unit,2);
			n /= 10;
		}
		
		sum += (int)Math.pow(n,2);
		
		if(sum==1){
			return true;
		}else{
			return isHappy1(sum);
		}
	}
	
	
}
