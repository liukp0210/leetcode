package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className ContainsNearbyDuplicate
 *@description 219.存在重复元素 II
 *@Auther 85291173@qq.com
 *@Date 2019/12/30 9:50
 *@Version
 */
public class ContainsNearbyDuplicate {
	
	/**
	 *
	 * 示例 1:
	 输入: nums = [1,2,3,1], k = 3
	 输出: true
	 示例 2:
	 输入: nums = [1,0,1,1], k = 1
	 输出: true
	 示例 3:
	 输入: nums = [1,2,3,1,2,3], k = 2
	 输出: false
	 *
	 */
	
	/**
	 * 1. 查找重复的数 以及对应的下标
	 *
	 *
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		//Set<Integer> set = new TreeSet<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])){
				return true;
			}
			set.add(nums[i]);
			if(set.size() > k){
				set.remove(nums[i-k]);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] ints = new int[]{99,99};
		boolean b = containsNearbyDuplicate(ints, 2);
		System.out.println(b);
	}
}
