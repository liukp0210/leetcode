package com.lkp.leetcode.BinarySearch;

/**
 *@className FirstBadVersion
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/28 14:28
 *@Version
 */
public class FirstBadVersion {
	/**
	 * You are a product manager and currently leading a team to develop a new product ,Unfortunately,
	 * the latest version of your product fails the quality check.Since each version is developed based on the previous version,
	 * all the versions after a bad version are also bad.
	 *
	 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
	 * ones to be bad.
	 * You are given an API bool isBadVersion(versiong) which will return whether version is bad . Implement a function to find the first bad
	 * version ,You should minimize the number of calls to the API.
	 *
	 * Example:
	 
	 Given n = 5, and version = 4 is the first bad version.
	 
	 call isBadVersion(3) -> false
	 call isBadVersion(5) -> true
	 call isBadVersion(4) -> true
	 
	 Then 4 is the first bad version. 
	 *
	 * 分析：第一种方式使用循环遍历的方式，调用isBadVersion方法进行判断，如果出现true则 表示是错误的版本；
	 * 第二种方式：使用二分法查找，left = 1 ; right = n ; mid = (left+right) >>>1
	 * 如果 isBadVersion(mid ) == true 则表示 错误版本再mid左边 即right = mid - 1;
	 * 如果 isBadVersion(mid) == false 则表示 错误版本在mid右边 即left = mid + 1
	 * 返回left;
	 *
	 */
	public static void main(String[] args) {
		int i = firstBadVersion(10);
		System.out.println(i);
	}
	public static int firstBadVersion(int n) {
		int left = 1 , right = n ;
		while (left <= right){
			int mid = (left+right) >>>1;
			//表示是正确的版本
			if(!isBadVersion(mid)){
				left = mid + 1;
			}else {
				right = mid - 1 ;
			}
		}
	
		return  left;
	}
	
	
	public static boolean isBadVersion(int version){
		if(version >= 8){
			return true;
		}
		return false;
	}
}
