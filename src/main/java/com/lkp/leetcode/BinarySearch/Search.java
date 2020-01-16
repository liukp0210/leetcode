package com.lkp.leetcode.BinarySearch;

/**
 *@className Search
 *@description 33. 搜索旋转排序数组
 *@Auther 85291173@qq.com
 *@Date 2020/1/16 10:55
 *@Version
 */
public class Search {
	/**
	 *
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	 你可以假设数组中不存在重复的元素。
	 你的算法时间复杂度必须是 O(log n) 级别。
	 *
	 * 1. 查找旋转的下标
	 * 2. 判断target是在哪个区间中
	 * 3.使用二分法查找
	 */
	public int search(int[] nums, int target) {
		if(nums.length == 0){
			return -1;
		}
		if(nums.length == 1){
			return nums[0] == target?0:-1;
		}
		int rotate_index = find_rotate_index(nums);
		if(nums[rotate_index] == target){
			return rotate_index;
		}
		if(rotate_index == 0){
			//TODO 0 nums.length-1
			return search(0,nums.length-1 ,nums,target);
		}
		if(target < nums[0]){
			//TODO rotate_index nums.length-1
			return search(rotate_index,nums.length-1 ,nums,target);
		}else{
			//TODO 0,rotate_index
			return search(0,rotate_index-1,nums,target);
		}
	}
	public int search(int left, int right,int[] nums,int target) {
		while (left <= right){
			int mid = (left + right)>>>1;
			if(nums[mid] == target){
				return mid;
			}else if (nums[mid] < target){
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public int find_rotate_index(int[] nums){
		int left = 0 ;
		int right = nums.length - 1;
		if(nums[left] < nums[right]){
			return 0;
		}
		while (left <= right){
			int mid = (left+right) >>>1;
			if(nums[mid] > nums[mid+1]){
				return mid+1;
			}else {
				if(nums[mid] < nums[left]){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
		}
		return 0;
	}
	
	public static int search2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target){
				return i;
			}
		}
		return -1 ;
	}
	//4,5,6,7,0,1,2,  4,5,6,7,0,1,2
	public static void main(String[] args) {
		int search = search2(new int[]{4,5,6,7,0,1,2}, 0);
		System.out.println(search);
	}
}
