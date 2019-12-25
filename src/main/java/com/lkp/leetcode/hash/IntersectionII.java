package com.lkp.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 *@className IntersectionII
 *@description 350. 两个数组的交集 II
 *@Auther 85291173@qq.com
 *@Date 2019/12/25 9:26
 *@Version
 */
public class IntersectionII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				++i;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				nums1[k++] = nums1[i++];
				++j;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}
}
