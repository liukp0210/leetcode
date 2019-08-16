package com.lkp.leetcode.sort;

import java.util.Arrays;

/**
 *@className Matrices
 *@description  距离顺序排列矩阵单元格
 *@Auther 85291173@qq.com
 *@Date 2019/8/5 16:01
 *@Version
 */
public class Matrices {
	/**
	 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
	 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
	 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
	 
	 示例 1：
	 输入：R = 1, C = 2, r0 = 0, c0 = 0
	 输出：[[0,0],[0,1]]
	 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
	 
	 示例 2：
	 输入：R = 2, C = 2, r0 = 0, c0 = 1
	 输出：[[0,1],[0,0],[1,1],[1,0]]
	 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
	 [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
	 
	 示例 3：
	 输入：R = 2, C = 3, r0 = 1, c0 = 2
	 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
	 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
	 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
	 提示：
	 1 <= R <= 100
	 1 <= C <= 100
	 0 <= r0 < R
	 0 <= c0 < C
	 *
	 */
	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] arr = new int[R*C][2];
		int s = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.println("["+i+", "+j+"]");
				arr[s] = new int[]{i,j};
				s++;
			}
		}
		Arrays.sort(arr,(int[] a,int[] b) ->{
			return Math.abs(a[0]-r0)+Math.abs(a[1]-c0)-Math.abs(b[0]-r0)-Math.abs(b[1]-c0) ;
		});
		return arr;
	}
	public static int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
		int[] l = new int[4];
		l[0] = r0 + c0;
		l[1] = r0 + C - 1 - c0;
		l[2] = R - 1 - r0 + c0;
		l[3] = R - 1 - r0 + C - 1 - c0;
		int m = 0;
		for(int i : l) {
			if(i > m) {
				m = i;
			}
		}
		
		int[][] ref= new int[R * C][2];
		int idx = 1;
		ref[0][0] = r0;
		ref[0][1] = c0;
		for(int i = 1; i <= m; i++) {
			for(int x = 0; x <= i; x++) {
				if(r0 - x >= 0 && c0 - (i - x) >= 0) {
					ref[idx][0] = r0 - x;
					ref[idx++][1] = c0 - (i - x);
				}
				if(r0 + x <= R - 1 && c0 - (i - x) >= 0 && x != 0 && i != x) {
					ref[idx][0] = r0 + x;
					ref[idx++][1] = c0 - (i - x);
					
				}
				if(r0 - x >= 0 && c0 + (i - x) <= C - 1  && x != 0 && i != x) {
					ref[idx][0] = r0 - x;
					ref[idx++][1] = c0 + (i - x);
					
				}
				if(r0 + x <= R - 1 && c0 + (i - x) <= C - 1) {
					ref[idx][0] = r0 + x;
					ref[idx++][1] = c0 + (i - x);
					
				}
			}
		}
		return ref;
	}
	
	public static void main(String[] args) {
		int[][] ints = allCellsDistOrder(2, 3, 1, 2);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i][0]);
			System.out.print(ints[i][1]);
			System.out.println();
			
		}
	}
}
