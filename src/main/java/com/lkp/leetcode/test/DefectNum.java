package com.lkp.leetcode.test;

/**
 *@className Defect
 *@description 缺失数字
 *@Auther 85291173@qq.com
 *@Date 2019/6/3 15:37
 *@Version
 */
public class DefectNum {
	
	/**
	 *
	 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
	 示例 1:
	 输入: [3,0,1]
	 输出: 2
	 示例 2:
	 输入: [9,6,4,2,3,5,7,0,1]
	 输出: 8
	 *
	 */
	
	public static void main(String[] args) {
		
		int[] maopao = maopao(new int[]{9,6,4,2,3,5,7,0,1});
		for (int i = 0; i < maopao.length; i++) {
			System.out.println(maopao[i]);

		}
		int[] a = new int[]{0,1};
		int i = missingNumber(a);
		System.out.println(i);
		
		int b = 0 ;
		for (int j = 0; j < a.length ; j++) {
			b += j+1;
		}
		
		for (int j = 0; j <a.length   ; j++) {
			b -= a[j];
		}
	}
	
	
	public static int missingNumber2(int[] nums){
		
		int a = nums.length;
		for (int i = 0; i < nums.length; i++) {
			 a ^= nums[i];
			 a ^= i;
		}
		return a;
	}
	
	/**
	 * 我的思路 1:对数组进行从小到大排序
	 * 2：循环排序后的数组，判断每个值是否与索引相等
	 *
	 * 错误示范
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums){
		int[] maopao = maopao(nums);
		for (int i = 0; i < maopao.length; i++) {
			if(maopao[i] != i){
				return i;
			}
		}
		return maopao.length+1;
	}
	
	/**
	 * [3,0,1]
	 * @param nums
	 * @return
	 */
	public static int[] maopao(int[] nums ){
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int temp = 0;
				if(nums[i]>nums[j]){
					temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
		
		return nums;
	}
	
}
