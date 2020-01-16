package com.lkp.leetcode.BinarySearch;

/**
 *@className GuessNumber
 *@description 374. 猜数字大小
 *@Auther 85291173@qq.com
 *@Date 2019/8/28 16:19
 *@Version
 */
public class GuessNumber {
	
	/**
	 *
	 * We are playing the Guess Game.The game is as follows;
	 * I pick a number from 1 to n,You have to guess which number I picked.
	 * Every time you guess wrong,I'll tell you whether the number is higher or lower.
	 * You call a pre-defined API guess(int num) which returns 3 possiboe results ( -1 , 1 or 0);
	 * -1: My number is lower
	 * 1: My number is higher
	 * 0: Congrats! You got it !
	 *
	 * Example:
	 * Input: n = 10 ,pick = 6
	 * Output: 6
	 *分析：使用二分法查找，每次减少一半查询范围；
	 * left = 1 , right = n ; mid = (left + right)>>>1
	 * 如果 guess(mid) == 0 return
	 * 如果 guess(mid) == -1  ;则 left = mid + 1;
	 * 如果 guess(mid) == 1 ; 则 right = mid;
	 *
	 * todo 如果为左中位数时，left = mid + 1 ；right = mid;
	 * todo 如果为右中位数时，left = mid  ；right = mid + 1;
	 */
	public static void main(String[] args) {
		int i = guessNumber(10);
		System.out.println(i);
	}
	public static int guessNumber(int n) {
		int left = 1 , right = n ;
		while (left <= right){
			int mid = (left + right) >>> 1;
			if(guess(mid) == 0){
				return mid;
			}else if(guess(mid) == -1){
				right = mid -1 ;
			}else{
				left = mid + 1;
			}
		}
		return 0;
	}
	
	public static int guess(int num){
		int n = 6;
		if(num < n){
			return 1;
		}else if(num > n){
			return -1;
		}
		return  0;
	}
	public int guessNumber2(int n) {
		int left = 0 ;
		int right = n;
		while (left <= right){
			int mid = (left + right)>>>1;
			int guess = guess(mid);
			if(guess == 0 ){
				return mid;
			}else if (guess ==  1){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return -1;
	}
	
	
}
