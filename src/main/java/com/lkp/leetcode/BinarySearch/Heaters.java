package com.lkp.leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@className Heaters
 *@description 供暖器
 *@Auther 85291173@qq.com
 *@Date 2019/8/30 16:46
 *@Version
 */
public class Heaters {
	/**
	 * Winter is coming! Your first job during the contest is to design a standard heater
	 * with fixed warm radius to warm all the houses.
	 * Now,you are given positions of houses and heaters on a horizontal line ,find out minimum radius of heaters
	 * so that all houses could be covered by those heaters.
	 *
	 * So,your input will be the positions of houses and heaters seperately,and your expected output will be the minimum
	 * radius standard of heaters.
	 *
	 * Note：
	 *  1. Numbers of house and heaters you are given are non-negative and will not exceed 25000.
	 *  2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
	 *  3. As long as a house is in the heaters' warm radius range,it can be warmed.
	 *  4. All the heaters follow your radius standard and the warm radius will the same.
	 *
	 *  Example 1:
	 
	 Input: [1,2,3],[2]
	 Output: 1
	 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
	  
	 
	 Example 2:
	 
	 Input: [1,2,3,4],[1,4]
	 Output: 1
	 Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
	 
	 分析：1.我们求的是 最短路径；
	 2. 双重循环，heaters为外层循环  houses为内层循环;定义n = 0表示最小加热半径  k为当前循环最小半径
	 3. 判断heaters[i] != houses[i] n++
	 4. else heaters[i] != houses[i] 终止循环进行下一个循环
	 5. 判断 n > k 则 n == k
	 6. 返回k;
	 */
	public static int findRadius(int[] houses, int[] heaters) {
		int k = 0;
		//房子
		for (int i = 0; i < houses.length ; i++) {
			//当前房子与供暖期比较，查看哪个供暖期离房子最近
			int b = Integer.MAX_VALUE;
			//供暖期
			for (int j = 0; j < heaters.length; j++) {
				if(houses[i] != heaters[j]){
					int a = Math.abs(houses[i] - heaters[j]);
					System.out.printf("当前房屋%s 距离供暖器%s号供暖期的距离为%s",houses[i],heaters[j],Math.abs(a));
					System.out.println();
					b = Math.min(b,a);
				}else{
					b = 0 ;
					break;
				}
				
			}
			System.out.println("b的值为" + b);
			k = Math.max(b,k);
		}
		return  k;
	}
	
	public static void main(String[] args) {
		int[] houses = new int[]{1,2,3,4};
		int[] heaters = new int[]{1,4};
		int radius = findRadius2(houses, heaters);
		System.out.println(radius);
	}
	
	public static int findRadius2(int[] houses, int[] heaters) {
		Arrays.sort(houses); //对两个数组排序
		Arrays.sort(heaters);
		int k = 0;
		//房子
		for (int i = 0; i < houses.length ; i++) {
			int house = houses[i];
			int left = 0;
			boolean flag = false;
			int right = heaters.length - 1;
			while (left < right){
				int mid = (right + left) >>> 1;
				if(house == heaters[mid]){
					//表示为加热器
					flag = true;
					break;
				}else if(house >  heaters[mid]){
					left = mid + 1;
				}else{
					right = mid + 1;
				}
			}
			System.out.println("left的值为" + left);
			System.out.println("right的值为" + right);
			if(!flag){
				k = Math.max(k,Math.abs(heaters[left]-house));
			}
		}
		return  k;
	}
	public int findRadius1(int[] houses, int[] heaters) {
		Arrays.sort(houses); //对两个数组排序
		Arrays.sort(heaters);
		int max = 0;
		int temp = 0;
		//从头开始遍历两个数组，每次只有一个下标+1
		for (int i = 0, j = 0; i < houses.length && j < heaters.length; ) {
			if (houses[i] <= heaters[j]) {
				temp = heaters[j] - houses[i];
				i++;
			} else if (j < heaters.length - 1) {
				temp = Math.min(heaters[j+1] - houses[i], houses[i] - heaters[j]);
				if (houses[i] < heaters[j + 1]) {
					i++;
				} else {
					j ++;
				}
			} else if (j == heaters.length - 1) {
				temp = houses[i] - heaters[j];
				i++;
			}
			max = max > temp ? max : temp;
		}
		return max;
	}
	
}
