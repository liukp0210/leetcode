package com.lkp.leetcode.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *@className Intersection
 *@description 349. 两个数组的交集
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 16:55
 *@Version
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			int nun1 = nums1[i];
			for (int j = 0; j < nums2.length; j++) {
				if(nun1 ==  nums2[j]){
					set.add(nun1);
					break;
				}
			}
		}
		int[] restult = new int[set.size()];
		int i = 0 ;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()){
			restult[i] = iterator.next();
			i++;
		}
		return restult;
	}
}
