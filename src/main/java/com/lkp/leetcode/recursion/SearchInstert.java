package com.lkp.leetcode.recursion;

/**
 *@className SearchInstert
 *@description 搜索插入位置
 *@Auther 85291173@qq.com
 *@Date 2019/6/11 17:39
 *@Version
 */
public class SearchInstert {
	/**
	 *
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 
	 你可以假设数组中无重复元素。
	 
	 示例 1:
	 
	 输入: [1,3,5,6], 5
	 输出: 2
	 示例 2:
	 
	 输入: [1,3,5,6], 2
	 输出: 1
	 示例 3:
	 
	 输入: [1,3,5,6], 7
	 输出: 4
	 示例 4:
	 
	 输入: [1,3,5,6], 0
	 输出: 0
	 *
	 *思路：1. 先判断数组中是否包含这个数字 如果包含返回下标位置，
	 * 如果不包含将目标值与数组中的值进行比较如果目标值比当前值小
	 *  则将目标值放入到当前位置
	 * 数组中的其他元素往后移；
	 *
	 */
	public static int searchInsert(int[] nums , int target){
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target){
				return i;
			}
			if(nums[i] > target){
				k ++;
			}
		}
		return nums.length - k;
	}
	
	/**
	 * 使用二分法查找效率会提高很多很多 但在go中觉得和顺序查找的效率一样没哟什么变化
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		int i = searchInsert2(nums, 2);
		System.out.println(i);
	}
	
	public static int searchInsert2(int[] nums ,int target){
		int left = 0;
		int right = nums.length -1;
		while (left <= right){
			int middle = (right + left)/2;
			if(nums[middle] == target){
				return middle;
			}
			if (nums[middle] > target) {
				right = middle - 1;
			}else if(nums[middle] < target){
				left = middle + 1;
			}
		}
		
		return left;
	}
}
