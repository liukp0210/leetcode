package com.lkp.leetcode.BinarySearch;

import java.util.Arrays;

/**
 *@className SearchRange
 *@description 34. 在排序数组中查找元素的第一个和最后一个位置
 *@Auther 85291173@qq.com
 *@Date 2020/1/17 9:48
 *@Version
 */
 public class SearchRange {
	
	/**
	 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
	 你的算法时间复杂度必须是 O(log n) 级别。
	 如果数组中不存在目标值，返回 [-1, -1]。
	 示例 1:
	 输入: nums = [5,7,7,8,8,10], target = 8
	 输出: [3,4]
	 示例 2:
	 输入: nums = [5,7,7,8,8,10], target = 6
	 输出: [-1,-1]
	 *
	 *
	 */
	public int[] searchRange(int[] nums, int target) {
		if(nums.length == 0){
			return new int[]{-1,-1};
		}
		int[] arr = new int[2];
		int left = 0 ,right = nums.length-1;
		while (left < right){
			int mid =  (right + left) /2;
			if(nums[mid] >= target ){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		if(nums[left] != target ){
			return new int[]{-1,-1};
		}
		arr[0] = left;
		left = 0 ;
		right = nums.length;
		while (left < right){
			int mid = left + (right - left) /2;
			if(nums[mid] > target ){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		arr[1] = nums[left-1] == target ?left-1:-1;
		return arr;
	}
	
	public static void main(String[] args) {
		SearchRange searchRange = new SearchRange();
		int[] ints = searchRange.searchRange(new int[]{5,7,7,8,8,10}, 8);
		System.out.println(Arrays.toString(ints));
	}
}
