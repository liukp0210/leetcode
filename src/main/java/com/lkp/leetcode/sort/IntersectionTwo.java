package com.lkp.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *@className IntersectTwo
 *@description Intersect fo Two Arrays II
 *@Auther 85291173@qq.com
 *@Date 2019/7/30 17:04
 *@Version
 */
 public class IntersectionTwo {
	/**
	 * Given two arrays,write a function to compute their intersection.
	 *Example 1:
	 Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 Output: [2,2]
	 Example 2:
	 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 Output: [4,9]
	 *NOTE:
	 * Each element in the result should appear as many times as it shows in booth arrays.
	 * The result can be any order.
	 *	思路：1.将数组转换成list，双重循环两个list
	 *2. 如果有参数相等，将参数添加到新的list中，然后再原list中删除
	 * 3. 将新建的list转换成数组
	 */
	public static int[] intersect(int[] nums1 ,int[] nums2){
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			list2.add(nums2[i]);
		}
		Iterator<Integer> iterator = list1.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			Iterator<Integer> iterator2 = list2.iterator();
			while (iterator2.hasNext()){
				Integer next2 = iterator2.next();
				if(next.equals(next2)){
					iterator.remove();
					iterator2.remove();
					list.add(next);
					break;
				}
			}
		}
		int[] nums3 = new int[list.size()];
		for (int i = 0 ; i < list.size(); i++) {
			nums3[i] = list.get(i);
		}
		
		return nums3;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,5};
		int[] nums2 = new int[]{9,4,9,8,4};
		int[] intersect = intersect(nums1, nums2);
		for (int num:intersect ) {
			System.out.println(num);
		}
	}
	
	
	/**
	 * 排序预处理
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
