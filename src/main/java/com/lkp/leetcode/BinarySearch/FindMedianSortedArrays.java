package com.lkp.leetcode.BinarySearch;

/**
 *@className FindMedianSortedArrays
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2020/4/13 9:48
 *@Version
 */
 public class FindMedianSortedArrays {
	
	/**
	 *
	 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
	 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	 你可以假设 nums1 和 nums2 不会同时为空。
	 示例 1:
	 nums1 = [1, 3]
	 nums2 = [2]
	 则中位数是 2.0
	 示例 2:
	 nums1 = [1, 2]
	 nums2 = [3, 4]
	 则中位数是 (2 + 3)/2 = 2.5
	 *
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int[]  arr = new int[nums1.length + nums2.length];
		int nums1Index = 0;
		int nums2Index = 0;
		for (int i = 0; i < arr.length ; i++) {
			if(nums1Index >= nums1.length){
				arr[i] = nums2[nums2Index];
				nums2Index++;
				continue;
			}else if(nums2Index >= nums2.length){
				arr[i] = nums1[nums1Index];
				nums1Index++;
				continue;
			}
			if(nums1[nums1Index] > nums2[nums2Index]){
				arr[i] = nums2[nums2Index];
				nums2Index++;
			}else{
				arr[i] = nums1[nums1Index];
				nums1Index++;
			}
		}
		if(arr.length%2==0){
			int i = arr[arr.length / 2-1] + arr[arr.length / 2 ];
			double v = Double.valueOf(i) / 2;
			return v;
		}else{
			return arr[arr.length / 2];
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		double medianSortedArrays = findMedianSortedArrays(nums1,nums2);
		System.out.println(medianSortedArrays);
	}
}
