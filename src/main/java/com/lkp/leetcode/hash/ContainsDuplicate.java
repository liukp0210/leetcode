package com.lkp.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *@className ContainsDuplicate
 *@description 存在重复元素
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 16:40
 *@Version
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer>  set = new HashSet<>();
		for (int i = 0; i < nums.length ; i++) {
			if(set.contains(nums[i])){
				return  true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
