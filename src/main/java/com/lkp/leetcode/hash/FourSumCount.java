package com.lkp.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *@className FourSumCount
 *@description 454. 四数相加 II
 *@Auther 85291173@qq.com
 *@Date 2020/1/8 11:33
 *@Version
 */
public class FourSumCount {
	/**
	 *
	 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
	 
	 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 231 - 1 。
	 
	 例如:
	 
	 输入:
	 A = [ 1, 2]
	 B = [-2,-1]
	 C = [-1, 2]
	 D = [ 0, 2]
	 
	 输出:
	 2
	 
	 解释:
	 两个元组如下:
	 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
	 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
	 *
	 *
	 *
	 *
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int ans = 0 ;
		int m = 0 ;
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			for (int j = 0; j < B.length; j++) {
				int b = B[j];
				for (int k = 0; k < C.length ; k++) {
					int c = C[k];
					for (int l = 0; l < D.length; l++) {
						int d = D[l];
						if (a + b + c + d == 0 ){
							ans++;
							m++;
						}
					}
				}
			}
		}
		System.out.println(m);
		return  ans;
	}
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		int ans = 0 ;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int i1 = A[i] + B[j];
				map.put(i1,map.getOrDefault(i1,0)+1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int i1 = -(C[i] + D[j]);
				ans += map.getOrDefault(i1, 0);
			}
		}
		return  ans;
	}
	
}
