package com.lkp.leetcode.test;

/**
 *@className MaxSubArray
 *@description 最大子序和
 *@Auther 85291173@qq.com
 *@Date 2019/7/29 10:24
 *@Version
 */
 public class MaxSubArray {
	/**
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 
	 示例:
	 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 输出: 6
	 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 */
	
	public static int maxSubArray(int[] nums) {
		int total = Integer.MIN_VALUE;
		int total1 = total(nums, total);
		return  total1;
	}
	
	
	public static int total(int[] nums,int total){
		if(nums.length > 0){
			int[] arr1 = new int[nums.length -1];
			int totalArr = 0;
			for (int i = 0; i < nums.length; i++) {
				totalArr += nums[i];
				if(total < totalArr){
					total = totalArr;
				}
				if(i>0){
					arr1[i-1] = nums[i];
				}
			}
			
			return total(arr1,total);
		}
		return  total;
	}
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int i = maxSubArray3(arr1);
		System.out.println(i);
	}
	
	public static int maxSubArray1(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0)
				sum += num;
			else
				sum = num;
			res = Math.max(res, sum);
		}
		return res;
	}
	public static  int maxSubArray3(int[] nums){
		int total = nums[0];
		int currTotal = 0;
		for (int num:nums) {
			if(currTotal > 0){
				currTotal += num;
			}else{
				currTotal = num;
			}
			total = Math.max(total,currTotal);
		}
		return total;
	}
}
