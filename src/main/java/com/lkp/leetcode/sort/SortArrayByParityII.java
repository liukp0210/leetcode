package com.lkp.leetcode.sort;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *@className SortArrayByParityII
 *@description sort array by parity II
 *@Auther 85291173@qq.com
 *@Date 2019/8/1 9:57
 *@Version
 */
 public class SortArrayByParityII {
	/**
	 * Given an array A of non-negative integers.half of the integers in A are odd,and half of the integers are even.
	 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even ,i is even.
	 * You many return any answer array that satisfies this condition.
	 *Example 1:
		 Input: [4,2,5,7]
		 Output: [4,5,2,7]
		 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
	 Note:
		 2 <= A.length <= 20000
		 A.length % 2 == 0
		 0 <= A[i] <= 1000
	 *
	 * 思路： 1.循环数组A，判断数组中基数位中的数是否为奇数，偶数位下标中是否是偶数，如果不是，将数据取出，放入到对应的奇数list，和偶数list中，将当前位修改为-1
	 * 2.循环数组，判断当下标%2==0时将偶数放入，不等于0是将奇数放入
	 */
	public static int[] sortArrayByParityII(int[] A){
		Queue<Integer> oddQueue = new ArrayDeque<>();
		Queue<Integer> evenQueue = new ArrayDeque<>();
		for (int i = 0; i < A.length; i++) {
			if(i%2==0){
				if(A[i]%2!=0){
					oddQueue.add(A[i]);
					A[i] = -1;
				}
			}else{
				if(A[i]%2!=1){
					evenQueue.add(A[i]);
					A[i] = -1;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if(A[i] == -1){
				if(i%2 ==0 ){
					A[i] = evenQueue.poll();
				}else{
					A[i] = oddQueue.poll();
				}
			}
		}
		return A;
	}
	
	/**
	 * 思路： 定义i,j; i为even j为odd 循环A，判断i 和A[i]%2是否==0如果等于则表示正确i+=2 ;J 同理
	 * 如果A[i]%2!=0 取出A[j]%2是否为0如果为0 则将A[i]和A[j]转换位置，i和j同时+2
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParityII2(int[] A){
		for (int i = 0,j=1 ; i < A.length && j < A.length;) {
			int temp ;
			if(i%2 ==0 ){
				if(A[i]%2!=0){
					if(A[j]%2==0){
						temp = A[i];
						A[i] = A[j];
						A[j] = temp;
						i+=2;
						j+=2;
					}else{
						j+=2;
					}
				}else{
					i+=2;
				}
			}else{
				if(A[j]%2!=1){
					if(A[i]%2!=0){
						temp = A[i];
						A[i] = A[j];
						A[j] = temp;
						i+=2;
						j+=2;
					}else{
						i+=2;
					}
				}else{
					j+=2;
				}
			}
		}
		return A;
	}
	/**
	 * 思路： 定义i,j; i为even j为odd 循环A，判断i 和A[i]%2是否==0如果等于则表示正确i+=2 ;J 同理
	 * 如果A[i]%2!=0 取出A[j]%2是否为0如果为0 则将A[i]和A[j]转换位置，i和j同时+2
	 * @param A
	 * @return
	 */
	public static int[] sortArrayByParityII3(int[] A){
		for (int i = 0; i < A.length; i+=2) {
			int temp ;
			int i1 = A[i];
			if(i1%2 == 0 ){
				continue;
			}
			for (int j = 1; j < A.length; j+=2) {
				if(A[j]%2 != 1){
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
					break;
				}
			}
		}
		return A;
	}
	public static void main(String[] args) {
		int[] ints = sortArrayByParityII3(new int[]{1,2,3,4,5,6,7,8,9,10});
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
			
		}
	}
}
