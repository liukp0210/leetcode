package com.lkp.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *@className Merge
 *@description 56. 合并区间
 *@Auther 85291173@qq.com
 *@Date 2020/4/16 9:54
 *@Version
 */
public class Merge {
	public static int[][] merge(int[][] intervals) {
		/**
		 *
		 * 循环数组 从1开始遍历(将 temp = intervals[0]作为第一个比对的对象)
		 * 新建list 如果temp[1] >= intervals[i][0] 说明区间重叠，判断temp[1] < intervals[i][1] 则替换temp[1] = intervals[i][1]
		 * 如果temp[1] >= intervals[i][0] 不成立 则将temp放入list中，i++；
		 * 循环完毕后判断一下list中的最后一个数组是否与temp相等，
		 */
		if(intervals.length == 0){
			return intervals;
		}
		int[] temp = intervals[0];
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i < intervals.length; i++) {
			if(temp[1] >= intervals[i][0] && temp[0] <= intervals[i][1] ){
				//&& temp[1] <= intervals[i][1]
				temp[1] = intervals[i][1]>=temp[1]? intervals[i][1]:temp[1];
				temp[0] = intervals[i][0]>= temp[0]?temp[0]:intervals[i][0];
			}else{
				list.add(temp);
				temp = intervals[i];
			}
		}
		list.add(temp);
		int[][] resArr = new int[list.size()][2];
		for (int i = 0; i < resArr.length; i++) {
			resArr[i] = list.get(i);
		}
		return resArr;
	}
	public static int[][] merge2(int[][] intervals) {
		if(intervals.length == 0){
			return intervals;
		}
		
		/**
		 * 1.排序将数组中按照左端点进行升序排列
		 * 2.循环遍历数组，如果数组中的右端大于temp的右端，则更新temp
		 */
		Arrays.sort(intervals,(a,b)->a[0] - b[0]);
		List<int[]> list = new ArrayList<>();
		int[] temp = intervals[0];
		for (int i = 1; i < intervals.length ; i++) {
			if(intervals[i][0] > temp[1] ){
				list.add(temp);
				temp = intervals[i];
			}else{
				temp[1] = Math.max(intervals[i][1],temp[1]);
			}
		}
		list.add(temp);
		int[][] res = new int[list.size()][2];
		list.toArray(res);
		return res;
	}
	
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] merge = merge2(arr);
		for (int i = 0; i < merge.length; i++) {
			System.out.println(merge[i][0]+ "   " + merge[i][1]);
		}
	}
}
