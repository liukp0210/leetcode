package com.lkp.leetcode.array;

import java.util.Arrays;
import java.util.List;

/**
 *@className DoubkeDunebsuibakArray
 *@description 二维数组
 *@Auther 85291173@qq.com
 *@Date 2019/11/7 9:25
 *@Version
 */
public class DoubkeDunebsuibakArray {
	private static void printArray(int[][] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; a[i] != null && j < a[i].length; ++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		int[][] doubleArray = new int[n][m];
		doubleArray[0] = new int[]{ 1, 2, 3};
		doubleArray[1] = new int[]{ 4, 5, 6};
		doubleArray[2] = new int[]{ 7, 8, 9};
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(doubleArray[i][j] + "\t");
//			}
//			System.out.println();
//		}
//
		int[] diagonalOrder = findDiagonalOrder(doubleArray);
		System.out.println(Arrays.toString(diagonalOrder));
	}
	
	/**
	 * 螺旋矩阵
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		int i = 0;
		int length = matrix.length * matrix[0].length;
		while (i < length){
		
		}
		return  null;
	}
	
	
	/**
	 * 对角线
	 * @param matrix
	 * @return
	 */
	public static int[] findDiagonalOrder(int[][] matrix) {
		if(matrix.length  == 0){
			return new int[]{};
		}
		int i = matrix.length * matrix[0].length;
		int[] resultArr = new int[i];
		int k = 0;
		int n = 0;
		int m = 0;
		boolean flag = true;
		while (k < i){
			resultArr[k] = matrix[n][m];
			k++;
			if(flag){
				if(n-1 < 0 ){
					flag = false;
					if( m+1 >= matrix[0].length){
						n++;
					}else{
						m++;
					}
				}else if( m+1 >= matrix[0].length){
					flag = false;
					n++;
				}else{
					n--;
					m++;
					
				}
			}else{
				
				if(n+1 >= matrix.length  ){
					flag = true;
					m++;
				}else if(m-1 < 0){
					flag = true;
					n++;
				}else{
					n++;
					m--;
				}
			}
		}
		return resultArr;
	}
}
