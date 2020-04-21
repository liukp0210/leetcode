package com.lkp.leetcode.BinarySearch;

/**
 *@className NumIslands
 *@description 200. 岛屿的数量
 *@Auther 85291173@qq.com
 *@Date 2020/4/20 14:58
 *@Version
 */
public class NumIslands {
	public int numIslands(char[][] grid) {
		if(null == grid || grid.length == 0 ){
			return 0;
		}
		int result = 0 ;
		int nc = grid.length;
		int nr = grid[0].length;
		for (int i = 0; i < nc ; i++) {
			for (int j = 0; j < nr ; j++) {
				if(grid[i][j] == 1){
					++result;
					dfs(grid,i,j);
				}
			}
		}
		return result;
	}
	
	private void dfs(char[][] grid, int i, int j) {
		
		int nc = grid.length;
		int nr = grid[0].length;
		if(i<0 || j < 0 || i >= nc || j >= nr){
			return;
		}
		grid[i][j] = 0;
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
	}
}
