package com.lkp.leetcode.BinarySearch;

/**
 *@className TwoSum
 *@description Two Sum II - Input array is sorted
 *@Auther 85291173@qq.com
 *@Date 2019/8/28 10:58
 *@Version
 */
public class TwoSum {
	/**
	 * Given an array of integers that is already sorted in ascending order,find two number such that they add up to a specific target number.
	 * The function twoSum should return indices of the two numbers such that they add up to the target,where index1 must be less than index2.
	 * Note:
	 * 	Your retruned answers (both index1 and index2) are not zero-based.
	 * 	Your may assume that each input would have exactly one solution and you may not use the same element twice.
	 * Example:
	 * 	Input: numbers = [2,7,11,15],target = 9
	 * 	Output: [1,2]
	 * 	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1,index2 = 2
	 * 分析： 双重for循环
	 * 1.外侧循环 i=0 内侧循环j = i+1
	 * 2. 在内侧循环判断 numbers[i] + numbers[j] == target
	 * 3. 返回 i+1,和j+1;
	 * 内侧循环：
	 * 1.如果target - numbers[i] > 0 进入内侧循环 left = i+1 ;right = numbers.length -1
	 * while(left <= right) 进入循环
	 * 判断如果 val == target - numbers[i]
	 * 假设：数组中的数都为正整数
	 * 则查找的范围为 numbers[i] - target < 0 && target - numbers[i] > 0
	 *
	 */
	public static void main(String[] args) {
		int[] resultArr = new int[]{5,25,75};
		int[] ints = twoSum4(resultArr, 100);
	}
	public static int[] twoSum4(int[] numbers, int target) {
		int[] resultArr = new int[2];
		int left = 0,right = numbers.length -1;
		while (left < right){
			int i = numbers[left] + numbers[right];
			if(i == target){
				resultArr[0] = left+1;
				resultArr[1] = right+1;
				return resultArr;
			}else if(i > target){
				--right;
			}else{
				++left;
			}
		}
		return resultArr;
	}
	public static int[] twoSum3(int[] numbers, int target) {
		int[] resultArr = new int[2];
		boolean flag = false;
		for (int i = 0; i < numbers.length; i++) {
			if(flag){
				break;
			}
			int i1 = target - numbers[i];
			int left = i+1 ,right = numbers.length -1;
			while (left <= right){
				int mid  = (left + right) >>>1;
				if(numbers[mid] == i1){
					resultArr[0] = i+1;
					resultArr[1] = mid+1;
					flag = true;
					break;
				}else if(numbers[mid] > i1){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			
		}
		
		return resultArr;
	}
	public int[] twoSum(int[] numbers, int target) {
		int[] resultArr = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] == target){
					resultArr[0] = i+1;
					resultArr[1] = j+1;
				}
			}
		}
		
		return resultArr;
	}
}
