package com.lkp.leetcode.days;

/**
 *@className Search
 *@description 33. 搜索旋转排序数组
 *@Auther 85291173@qq.com
 *@Date 2020/4/27 9:31
 *@Version
 */
public class Search {
	public static int search(int[] nums, int target) {
		if(null == nums || nums.length == 0){
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		
		if(nums[left] < nums[right]){
			while (left <= right){
				int mid = (left + right) >>1;
				if(nums[mid] == target){
					return mid;
				}else if( nums[mid]  < target ){
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
			return -1;
		}else{
			if(target == nums[left]){
				return left;
			}else {
				while (left <= right){
					int mid = (left + right) >>1;
					if(nums[mid] == target){
						return mid;
					}else if(nums[mid]  < nums[0] && nums[mid]  < target ){
						left = mid + 1;
					}else if(nums[mid]  < nums[0] && nums[mid]  > target ){
						right = mid - 1;
					}else if(nums[mid]  > nums[0] && nums[mid]  < target ){
						left = mid + 1;
					}else{
						right = mid - 1;
					}
				}
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{4,5,6,7,0,1,2};
//		int[] arr = new int[]{1,3,5};
		int[] arr = new int[]{4,5,6,7,0,1,2};
		int search = search(arr, 5);
		System.out.println(search);
	}
}
