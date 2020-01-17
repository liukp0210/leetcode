package com.lkp.leetcode.BinarySearch;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@className FindClosestElements
 *@description 658. 找到 K 个最接近的元素
 *@Auther 85291173@qq.com
 *@Date 2020/1/17 11:41
 *@Version
 */
public class FindClosestElements {
	/**
	 *
	 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
	 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
	 示例 1:
	 输入: [1,2,3,4,5], k=4, x=3
	 输出: [1,2,3,4]
	 示例 2:
	 输入: [1,2,3,4,5], k=4, x=-1
	 输出: [1,2,3,4]
	 *
	 *
	 */
	public int test(int[] nums,int target){
		int left  = 0 , right = nums.length-1;
		while (left < right){
			int mid = left + (right - left)/2;
			if(nums[mid] >= target){
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		if(nums[left] == target){
			return left;
		}
		
		return left-1;
	}
	
	public static void main(String[] args) {
		FindClosestElements findClosestElements = new FindClosestElements();
		int[]  arr = new int[]{1,1,1,10,10,10};
//		int[]  arr = new int[]{0,0,1,2,3,3,4,7,7,8};
//		int[]  arr = new int[]{0,1,2,3,3,4,5,6,7,8};
//		int[]  arr = new int[]{0,0,0,1,3,5,6,7,8,8};
		List<Integer> closestElements = findClosestElements.findClosestElements5(arr, 1, 9);
//		List<Integer> closestElements = findClosestElements.findClosestElements(arr, 3, 5);
//		List<Integer> closestElements = findClosestElements.findClosestElements4(arr, 2, 2);
		System.out.println(closestElements.toString());
//		int test = findClosestElements.test(arr, 3);
//		System.out.println(arr[test]);
//		System.out.println(test);
	}
	
	
	public List<Integer> findClosestElements4(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<>();
		if(x <= arr[0]){
			for (int i = 0; i < k; i++) {
				list.add(arr[i]);
			}
			return list;
		}
		int left = 0 ,right = arr.length-1;
		x = arr[search(arr, x)];
//		x = arr[test(arr, x)];
		while (right - left > k){
			int i = x - arr[left];
			int i2 = arr[right] - x;
			if( i > i2){
				left++;
			}else{
				right--;
			}
		}
		for (int i = left; i < right; i++) {
			list.add(arr[i]);
		}
		return list;
	}
	public List<Integer> findClosestElements5(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<>();
		if(x <= arr[0]){
			for (int i = 0; i < k; i++) {
				list.add(arr[i]);
			}
			return list;
		}
		int left = 0 ,right = arr.length-k;
		while (left < right){
			int mid = left + (right - left) /2;
			if(x - arr[mid] > arr[mid + k] -x){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		for (int i = left; i < left + k; i++) {
			list.add(arr[i]);
		}
		return list;
	}
	//TODO 解题思路错误
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<>();
		if(x <= arr[0]){
			for (int i = 0; i < k; i++) {
				list.add(arr[i]);
			}
			return list;
		}
		int search = search(arr, x);
		int index = 0;
		if(search - k >= 0){
			index =  search - (k - 1);
		}
		for (int i = 0; i < k; i++) {
			int search1 = search(arr, arr[index]);
			list.add(arr[search1]);
			index++;
		}
		return list;
	}
	
	private int search(int[] arr, int x) {
		int left = 0 ;
		int right = arr.length-1;
		//找到最接近
		while (left < right){
			int mid = left + (right - left)/2;
			if(arr[mid] >=  x){
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		if(arr[left] == x){
			return left;
		}
		int i = arr[left] - x;
		int i2 = x - arr[left-1];
		
		if( i > i2 ){
			return left - 1;
		}
		return left;
	}

}
