package com.lkp.leetcode.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *@className Intersection
 *@description Intersection of two Arrays
 *@Auther 85291173@qq.com
 *@Date 2019/7/30 16:24
 *@Version
 */
 public class Intersection {
	/**
	 * Given two arrays,write a function to compute theic intersection.
	 *
	 *Example 1:
	 Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 Output: [2]
	 Example 2:
	 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 Output: [9,4]
	 * NOTE:
	 * Each element in the result must be unique.
	 * The result can bu in any order.
	 * 思路 ：1.新建一个Integer类型Set集合，双层循环判断nums1中是否包含nums2中的元素如果包含，将元素放入到set集合中
	 * 2.将set集合转换成数组返回
	 */
	public int[] intersection(int[] nums1,int[] nums2){
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			int i1 = nums2[i];
			for (int j = 0; j < nums1.length ; j++) {
				if (i1 == nums1[j]){
					set.add(nums1[j]);
				}
			}
		}
		int[] nums3 = new int[set.size()];
		int i = 0;
		for (Integer num: set ) {
			nums3[i] = num;
			i++;
		}
		return nums3;
	}
}
