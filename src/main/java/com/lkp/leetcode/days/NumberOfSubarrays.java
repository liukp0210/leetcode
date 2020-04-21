package com.lkp.leetcode.days;

/**
 *@className NumberOfSubarrays
 *@description 1248 优美子数组
 *@Auther 85291173@qq.com
 *@Date 2020/4/21 9:55
 *@Version
 */
public class NumberOfSubarrays {
	
	public static int numberOfSubarrays(int[] nums, int k) {
		int result = 0 ;
		int index = 0 ;
		int tempIndex = index;
		int flag = 0;
		while (index < nums.length  ){
			if(nums[tempIndex]%2 == 1){
				flag++;
			}
			if(flag == k){
				result++;
			}else if(flag > k){
				index++;
				flag = 0;
				tempIndex = index;
				continue;
			}
			tempIndex++;
			if(tempIndex >= nums.length){
				index++;
				flag = 0;
				tempIndex = index;
			}
		}
		return result;
	}
	public static int numberOfSubarrays2(int[] nums, int k) {
		int length = nums.length;
		int[] odd = new int[length+2];
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < length; i++) {
			if(nums[i]%2 == 1){
				odd[++cnt] = i ;
			}
		}
		odd[0] = -1;
		odd[++cnt] = length;
		for (int i = 1; i +k <= cnt ; i++) {
			ans += (odd[i]-odd[i-1])*(odd[i+k] - odd[i+k-1]);
		}
		return ans;
	}
	//45627,50891,94884,11286,35337,46414,62029,20247,72789,89158,54203,79628,25920,16832,47469,80909
	public static void main(String[] args) {
		int i = numberOfSubarrays2(new int[]{1,1,2,1,1}, 3);
		System.out.println(i);
	}
}
