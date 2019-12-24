package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className FindRestaurant
 *@description 599. 两个列表的最小索引总和
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 21:23
 *@Version
 */
public class FindRestaurant {
	
	
	//todo  最小索引和！！！！！就是两个加起来的索引应该是最小的
	public String[] findRestaurant2(String[] list1, String[] list2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list1.length; i++)
			map.put(list1[i], i);
		List<String> res = new ArrayList<>();
		int min_sum = Integer.MAX_VALUE, sum;
		for (int j = 0; j < list2.length && j <= min_sum; j++) {
			if (map.containsKey(list2[j])) {
				sum = j + map.get(list2[j]);
				if (sum < min_sum) {
					res.clear();
					res.add(list2[j]);
					min_sum = sum;
				} else if (sum == min_sum)
					res.add(list2[j]);
			}
		}
		return res.toArray(new String[res.size()]);
		
	}
	
	public String[] findRestaurant3(String[] list1, String[] list2) {
		HashMap<String,Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i],i);
		}
		List<String> list = new ArrayList<>();
		int min_sum = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length  && i <= min_sum; i++) {
			if(map.containsKey(list2[i])){
				int i1 = map.get(list2[i]) + i;
				if(i1 < min_sum){
					list.clear();
					list.add(list2[i]);
					min_sum = i1;
				}else if (i1 == min_sum){
					list.add(list2[i]);
				}
			}
		}
		return list.toArray(new String[list.size()]);
		
	}
	
	public static void main(String[] args) {
		
		String[] arr1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
		String[] arr2 = new String[]{"KFC","Shogun","Burger King"};
		FindRestaurant findRestaurant = new FindRestaurant();
		String[] restaurant = findRestaurant.findRestaurant3(arr1, arr2);
		System.out.println(Arrays.toString(restaurant));
	}
}
