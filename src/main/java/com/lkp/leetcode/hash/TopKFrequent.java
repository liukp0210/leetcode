package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className TopKFrequent
 *@description 347. 前 K 个高频元素
 *@Auther 85291173@qq.com
 *@Date 2020/1/8 10:20
 *@Version
 */
public class TopKFrequent {
	
	/**
	 *
	 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
	 示例 1:
	 输入: nums = [1,1,1,2,2,3], k = 2
	 输出: [1,2]
	 示例 2:
	 输入: nums = [1], k = 1
	 输出: [1]
	 说明：
	 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
	 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
	 *
	 */
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		}
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < k; i++) {
			int s = 0;
			int ans = 1;
			for (Map.Entry<Integer,Integer> m :map.entrySet()) {
				if(m.getValue() >= ans){
					ans = m.getValue();
					s = m.getKey();
				}
			}
			list.add(s);
			map.remove(s);
		}
		return  list;
	}
	
	public static void main(String[] args) {
		int[]  num = new int[]{4,1,-1,2,-1,2,3};
		TopKFrequent t = new TopKFrequent();
		List<Integer> list = t.topKFrequent(num, 2);
		
	}
}
