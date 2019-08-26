package com.lkp.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@className RepeatNum
 *@description 重复数
 *@Auther 85291173@qq.com
 *@Date 2019/6/4 14:54
 *@Version
 */
public class RepeatNum {
	/**
	 *
	 * 给定一个整数数组，判断是否存在重复元素。
	 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
	 示例 1:
	 输入: [1,2,3,1]
	 输出: true
	 示例 2:
	 输入: [1,2,3,4]
	 输出: false
	 示例 3:
	 输入: [1,1,1,3,3,4,3,2,4,2]
	 输出: true
	 *
	 * 使用set的特性 将数据放入到set集合中 比较两个数据的长度
	 *
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		return set.size() == nums.length ? false:true;
	}
	
	
	/**
	 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
	 示例 1:
	 输入: nums = [1,2,3,1], k = 3
	 输出: true
	 示例 2:
	 输入: nums = [1,0,1,1], k = 1
	 输出: true
	 示例 3:
	 输入: nums = [1,2,3,1,2,3], k = 2
	 输出: false
	 *
	 *
	 */
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[i] == nums[j] && i != j){
					int abs = Math.abs(j-i);
					if(abs <= k){
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.keySet().contains(nums[i])){
				Integer integer = map.get(nums[i]);
				int i1 = integer - i;
				if(Math.abs(i1) <= k){
					return true;
				}
			}
			map.put(nums[i],i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] intArr = new int[]{1,2,3,1,2,3};
		boolean b = containsNearbyDuplicate2(intArr, 2);
		System.out.println(b);
	}
}
