package com.lkp.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 *@className Solution
 *@description 下一个更大的元素I
 *@Auther 85291173@qq.com
 *@Date 2019/8/16 11:36
 *@Version
 */
 public class Solution {
	/**
	 * You are given two arrays (without duplicates) nums1 and nums2 where nums1's elelments are subset of nums2.
	 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
	 *
	 * The next Greater Number of a number X in nums1 is the first greater number to its right in nums2.If it does not exist,
	 * output-1 for this number.
	 *
	 *Example 1:
	 * 	Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
		 Output: [-1,3,-1]
		 Explanation:
		 For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
		 For number 1 in the first array, the next greater number for it in the second array is 3.
		 For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
	 *Example 2:
		 *Input: nums1 = [2,4], nums2 = [1,2,3,4].
		 Output: [3,-1]
		 Explanation:
		 For number 2 in the first array, the next greater number for it in the second array is 3.
		 For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
	 *Note:
	 * 	1.All elements in nums1 and nums2 are unique.
	 * 	2.The length of both nums1 and nums2 would not execed 1000.
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
 	
 	
 	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[]  arr = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int i1 = nums1[i];
			boolean flag = false;
			for (int j = 0; j < nums2.length ; j++) {
				int i2 = nums2[j];
				int k = 0;
				if(i2 == i1){
					k = 1;
				}
				if(i1 < i2 && k == 1){
					arr[i] = i2;
					flag = true;
					break;
				}
			}
			if(!flag){
				arr[i] = -1;
			}
		}
		return  arr;
	}
	
	public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();
		
		int[] result = new int[nums1.length];
		
		for(int num : nums2) {
			while(!stack.isEmpty() && stack.peek()<num){
				hasMap.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		for(int i = 0; i < nums1.length; i++){
			
			result[i] = hasMap.getOrDefault(nums1[i], -1);
		}
		
		return result;
		
	}
	
	public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length ; i++) {
			while (!stack.isEmpty()&& stack.peek() < nums2[i]){
				map.put(stack.pop(),nums2[i]);
			}
			stack.push(nums2[i]);
		}
		
		for (int i = 0; i < nums1 .length; i++) {
			int i1 = map.getOrDefault(nums1[i],-1);
			result[i] =  i1;
		}
		return result;
	}
	/**
	 *nums1和nums2中所有元素是唯一的。
	  nums1和nums2 的数组大小都不超过1000。
	 * @param args
	 */
	public static void main(String[] args) {
	 	int[] nums1 = new int[]{4,1,2};
	 	int[] nums2 = new int[]{1,3,4,2};
		int[] ints = nextGreaterElement3(nums1, nums2);
		for (int i = 0; i < ints.length ; i++) {
			System.out.println(ints[i]);
		}
	}
}
