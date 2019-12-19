package com.lkp.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *@className IsHappy
 *@description 202. 快乐数
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 17:10
 *@Version
 */
public class IsHappy {
	Set<Integer> set = new HashSet<>();
	public boolean isHappy(int n) {
		int sum = 0 ;
		while (n>0){
			int i = n % 10;
			sum += i*i;
			n = n/10;
		}
		if(sum == 1){
			return true;
		}
		if(set.contains(sum)){
			return false;
		}
		set.add(sum);
		return isHappy(sum);
	}
	
	public static void main(String[] args) {
		IsHappy isHappy = new IsHappy();
		boolean happy = isHappy.isHappy(2);
		System.out.println(happy);
	}
}
