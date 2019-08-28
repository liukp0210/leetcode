package com.lkp.leetcode.BinarySearch;

/**
 *@className ValidPerfectSquare
 *@description 有效的完全平方数
 *@Auther 85291173@qq.com
 *@Date 2019/8/27 14:48
 *@Version
 */
public class ValidPerfectSquare {
	/**
	 * Given a positive integer num,write a function which returns True if num is perfect square else False.
	 * Note: Do not use built-in library function such as sqrt.
	 *
	 *Example 1:
	 * 	Input: 16
	 * 	Output: true
	 *
	 * Example 2:
	 * 	Input: 14
	 * 	Output: false
	 *
	 * 	分析：使用二分法查找 left = 0 ; right = num/2; min = (right + left) >>>1;TODO left,right都应该为long类型
	 * 	循环条件是 left < right ;不满足条件返回false;
	 * 	如果 mid*mid == num 返回true
	 */
	public static boolean isPerfectSquare(int num) {
		long left = 0 , right = num/2;
		if(num == 0 || num == 1){
			return true;
		}
		while (left <= right){
			long mid = (right + left) >>>1;
			if(mid*mid == num){
				return true;
			}else if(mid*mid > num){
				right = mid -1 ;
				System.out.println("mid=" + mid);
				System.out.println("left=" + left);
			}else {
				System.out.println("left=" + left);
				System.out.println("right=" + right);
				System.out.println("mid=" + mid);
				left = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		boolean perfectSquare = isPerfectSquare(808201);
		System.out.println(perfectSquare);
	}
	
	
	public boolean isPerfectSquare2(int num) {
		//解法一：暴力循环
		// double i = 1;
		// while(i * i < num) i++;
		// return i * i == num;
		
		//解法二：二分查找
		// int left = 1;
		// int right = num;
		// while(left <= right){
		//     int mid = (left + right) >>> 1;
		//     if((double)mid * mid < num) left = mid + 1;
		//     else if((double)mid * mid > num) right = mid - 1;
		//     else return true;
		// }
		// return false;
		
		//解法三：数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
		// int i = 1;
		// while(num > 0) {
		//     num -= i;
		//     i += 2;
		// }
		// return num == 0;
		
		//解法四：牛顿迭代法
		if(1 == num) return true;
		int i = num / 2;
		while((double)i * i > num){
			i = (i + num / i) / 2;
		}
		return i * i == num;
	}
	
}
