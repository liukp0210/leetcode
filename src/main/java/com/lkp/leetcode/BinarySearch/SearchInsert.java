package com.lkp.leetcode.BinarySearch;

/**
 *@className SearchInsert
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/27 9:46
 *@Version
 */
public class SearchInsert {
	/**
	 * Given a sorted array and a target value.return the index if the target is found.
	 * If not ,return the index where it would be if it were inserted in order.
	 *
	 * You may assume no duplicates in the array.
	 * Example 1:
	 
	 Input: [1,3,5,6], 5
	 Output: 2
	 Example 2:
	 
	 Input: [1,3,5,6], 2
	 Output: 1
	 Example 3:
	 
	 Input: [1,3,5,6], 7
	 Output: 4
	 Example 4:
	 
	 Input: [1,3,5,6], 0
	 Output: 0
	 
	 *
	 * 分析：循环数组，对比value值，如果数组[i] = value，则返回当前下标
	 * 如果，数组[i] > value 时，则表示插入到当前位置，返回当前下标
	 *
	 */
	
	public int searchInsert(int[] nums, int target) {
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if(target <= nums[i]){
				flag = true;
				return i;
			}
		}
		return nums.length;
	}
	//1,3,5,6 5
	public static int searchInsert2(int[] nums, int target) {
		int left = 0 ;
		int right = nums.length -1;
		if(nums[right] < target){
			return nums.length;
		}
		while (left <= right){
			int mid = (left+right) >>> 1;
			if(nums[mid] == target){
				return mid;
			} else if (nums[mid] > target){
				//左边
				right = mid - 1;
			}else{
				//右边
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int i = searchInsert2(new int[]{1, 3, 5, 6}, 2);
		System.out.println(i);
	}
}
