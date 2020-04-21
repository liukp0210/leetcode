package com.lkp.leetcode.days;

/**
 *@className MaxArea
 *@description 11.盛最多水的容器
 *@Auther 85291173@qq.com
 *@Date 2020/4/20 17:17
 *@Version
 */
 public class MaxArea {
	public int maxArea(int[] height) {
		if(height.length <= 1){
			return 0;
		}
		int maxArea = 0 ;
		for (int i = 0; i < height.length ; i++) {
			for (int j = i+1; j < height.length ; j++) {
				int min = Math.min(height[i],height[j]);
				maxArea =  Math.max(min * (j-i),maxArea);
			}
		}
		
		return maxArea;
	}
	//双指针
	public int maxArea2(int[] height) {
		if(height.length <= 1){
			return 0;
		}
		int maxArea = 0 ;
		int l = 0 ,r = height.length -1 ;
		while (l < r){
			if(height[l] <= height[r] ){
				maxArea = Math.max(height[l]*(r-l),maxArea);
				l++;
			}else{
				maxArea = Math.max(height[r]*(r-l),maxArea);
				r--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		MaxArea maxArea = new MaxArea();
		int i = maxArea.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
		System.out.println(i);
	}
}
