package com.lkp.leetcode.BinarySearch;

/**
 *@className FindMin
 *@description 153. 寻找旋转排序数组中的最小值
 *@Auther 85291173@qq.com
 *@Date 2020/1/16 17:18
 *@Version
 */
public class FindMin {
	
	
	/**
	 *
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	 请找出其中最小的元素。
	 你可以假设数组中不存在重复元素。
	 示例 1:
	 输入: [3,4,5,1,2]
	 输出: 1
	 示例 2:
	 输入: [4,5,6,7,0,1,2]
	 输出: 0
	 *
	 *
	 */
	public int findMin(int[] nums) {
		if(nums.length == 1){
			return nums[0];
		}
		int left = 0 ,right = nums.length - 1;
		if(nums[left] < nums[right]){
			return nums[0];
		}
		while (left < right){
			int mid = left + (right -left)/2;
			if(nums[mid] > nums[mid+1]){
				return nums[mid +1]  ;
			}else{
				if(nums[mid] < nums[left]){
					right = mid ;
				}else{
					left = mid + 1;
				}
			}
		}
		return nums[right];
	}
	public int findMin3(int[] nums) {
		if(nums.length == 1){
			return nums[0];
		}
		int left = 0 ,right = nums.length - 1;
		if(nums[left] < nums[right]){
			return nums[0];
		}
		while (left < right){
			int mid = left + (right - left)/2;
			if(nums[mid] < nums[right]){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return nums[right];
	}
	public int findMin2(int[] nums) {
		if(nums.length == 1){
			return nums[0];
		}
		int left = 0 ;
		int right = nums.length - 1;
		if(nums[left] < nums[right]){
			return nums[0];
		}
		while (left <= right){
			int mid = (left+right) >>>1;
			if(nums[mid] > nums[mid+1]){
				return nums[mid+1];
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
	
	public static void main(String[] args) {
		FindMin findMin = new FindMin();
		int min = findMin.findMin2(new int[]{2,3,4,5,1});
		System.out.println(min);
	}
}
