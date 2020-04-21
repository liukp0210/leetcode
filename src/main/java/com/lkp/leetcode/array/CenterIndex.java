package com.lkp.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@className CenterIndex
 *@description 寻找数组的中心索引
 *@Auther 85291173@qq.com
 *@Date 2019/11/1 10:30
 *@Version
 */
public class CenterIndex {
	
	public static int pivotIndex(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		int leftSum = 0 ;
		for (int i = 0; i < nums.length; i++) {
			if(leftSum == (sum - nums[i] - leftSum)){
				return  i;
			}
			leftSum += nums[i];
		}
		return -1;
	}
	
	
	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int j = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != max){
				if(max  < (nums[i]*2)){
					return -1;
				}
			}else{
				j = i;
			}
		}
		return j;
	}
	
	public static void main(String[] args) {
//		int[]  nums = new int[]{0,0,0,1};
//		int i = pivotIndex(nums);
//		int i = dominantIndex(nums);
//		System.out.println(i);
		
		int[] ints = plusOne(new int[]{ 9});
		System.out.println(Arrays.toString(ints));
	}
	
	public static int[] plusOne(int[] digits) {
		List<Integer> list = new ArrayList<>();
		for (int i = digits.length-1; i >=0 ; i--) {
			if (i == digits.length - 1) {
				digits[i] = digits[i] + 1;
			}
			if (digits[i] > 9) {
				list.add(0);
				if(i-1 >= 0){
					digits[i-1] = digits[i-1] + 1;
				}else{
					
					list.add(1);
				}
			} else {
				list.add(digits[i]);
			}
		}
			
		int[] ints = new int[list.size()];
		int j = 0;
		for (int i = list.size() - 1; i >= 0 ; i--) {
			ints[j] = list.get(i);
			j++;
		}
		return ints;
	}
	
	public static int[] plusOne1(int[] digits) {
		for (int i = digits.length - 1; i >= 0 ; i--) {
			digits[i]++;
			digits[i] %= 10;
			if(digits[i] != 0){
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
	
}
