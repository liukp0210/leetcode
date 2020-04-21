package com.lkp.leetcode.matrix;

import java.util.Date;

/**
 *@className UpdateMatrix
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2020/4/15 10:51
 *@Version
 */
public class UpdateMatrix {
	public static int[][] updateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix[i].length ; j++) {
				if(matrix[i][j]!= 0){
					int i2 = searchLeft(matrix, i, j);
					int i3 = searchRight(matrix, i, j);
					int min = Math.min(i2, i3);
					matrix[i][j] = min;
				}
			}
			
		}
		
		return matrix;
	}
	public static int searchUp(int[][] arr,int i,int j){
		int tempUp = 1;
		//向上
		if(i >= 0){
			int i1 = arr[i][j];
			if(i1 == 0){
				return 0;
			}
			tempUp += searchUp(arr, i - 1, j);
			return tempUp;
		}
		return 20000;
	}
	public static int searchDown(int[][] arr,int i,int j){
		//向下
		int tempDown = 1;
		if(i < arr.length ){
			int i1 = arr[i ][j];
			if(i1 == 0 ){
				return 0;
			}
			tempDown += searchDown(arr, i + 1, j);
			return tempDown;
		}
		return 20000;
	}
	public static int searchLeft(int[][] arr,int i,int j){
		int min = 20000;
		for (int k = j; k >= 0 ; k--) {
			int i2 = searchDown(arr, i, k );
			int i4 = searchUp(arr, i, k );
			
			min = Math.min(min, i4+j-k);
			min = Math.min(i2+j-k, min);
		}
		return min;
	}
	public static int searchRight(int[][] arr,int i,int j){
		int min = 20000;
		for (int k = j; k < arr[i].length ; k++) {
			int i2 = searchDown(arr, i, k);
			int i4 = searchUp(arr, i, k );
			min = Math.min(min, i4+k-j);
			min = Math.min(i2+k-j, min);
		}
		return min;
	}
	
	public static void main(String[] args) {
		/**
		 * [0,1,0,1,1],
		 * [1,1,0,0,1],
		 * [0,0,0,1,0],
		 * [1,0,1,1,1],
		 * [1,0,0,0,1]
		 * 输入
		 * [0,0,1,0,1,1,1,0,1,1],
		 * [1,1,1,1,0,1,1,1,1,1],
		 * [1,1,1,1,1,0,0,0,1,1],
		 * [1,0,1,0,1,1,1,0,1,1],
		 * [0,0,1,1,1,0,1,1,1,1],
		 * [1,0,1,1,1,1,1,1,1,1],
		 * [1,1,1,1,0,1,0,1,0,1],
		 * [0,1,0,0,0,1,0,0,1,1],
		 * [1,1,1,0,1,1,0,1,0,1],
		 * [1,0,1,1,1,0,1,1,1,0]
		 * 输出
		 * [0,0,1,0,1,2,1,0,1,2],
		 * [1,1,2,1,0,1,1,1,4,5],
		 * [2,1,3,1,1,0,0,0,1,2],
		 * [1,0,1,0,1,1,1,0,1,2],
		 * [0,0,1,1,1,0,1,1,2,4],
		 * [1,0,1,2,1,1,1,2,1,4],
		 * [1,1,1,1,0,1,0,1,0,1],
		 * [0,1,0,0,0,1,0,0,1,2],
		 * [1,1,1,0,1,1,0,1,0,1],
		 * [1,0,1,1,1,0,1,2,1,0]
		 *预期
		 * [0,0,1,0,1,2,1,0,1,2],
		 * [1,1,2,1,0,1,1,1,2,3],
		 * [2,1,2,1,1,0,0,0,1,2],
		 * [1,0,1,0,1,1,1,0,1,2],
		 * [0,0,1,1,1,0,1,1,2,3],
		 * [1,0,1,2,1,1,1,2,1,2],
		 * [1,1,1,1,0,1,0,1,0,1],
		 * [0,1,0,0,0,1,0,0,1,2],
		 * [1,1,1,0,1,1,0,1,0,1],
		 * [1,0,1,1,1,0,1,2,1,0]
		 */
		
		int[][] arr1 = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
//		int[][] arr1 = new int[][]{{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
//		int[][] arr1 = new int[][]{{0,1,1,0,0},{0,1,1,0,0},{0,1,0,0,1},{1,1,1,1,0},{1,0,0,1,0}};
		int[][] ints = updateMatrix(arr1);
		/**
		 * [0,1,0,1,2],
		 * [1,1,0,0,1],
		 * [0,0,0,1,0],
		 * [1,0,1,1,1],
		 * [1,0,0,0,1]
		 */
		for (int i = 0; i < ints.length; i++) {
			for (int j = 0; j < ints[i].length; j++) {
				System.out.print(ints[i][j]);
			}
			System.out.println();
		}
		
		
		Date date = new Date(1586880000000L);
		System.out.println(date);
	}
	
	public int[][] updateMatrix2(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		// 遍历
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = row + column;
				}
				if (i > 0) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i-1][j] + 1);
				}
				if (j > 0) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
				}
			}
		}
		
		for (int i = row - 1; i >= 0; i--) {
			for (int j = column - 1; j >= 0; j--) {
				if (i < row - 1) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
				}
				if (j < column - 1) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
				}
			}
		}
		return matrix;
	}
	
}
