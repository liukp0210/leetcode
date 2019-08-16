package com.lkp.leetcode.sort;

/**
 *@className RelatoveSortArray
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/2 11:44
 *@Version
 */
 public class RelatoveSortArray {
	/**
	 *Given two arrays arr1 and arr2 ,the elements of arr2 are distinct,and all elements in arr2 are also in arr1.
	 * Sort the elements of arr1 such that the relative ordering of item in arr1 are the same as in arr2.
	 * Elements that donot appear in arr2 should be placed at the end of arr1 in acscending order.
	 *Example 1:
	 
	 Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	 Output: [2,2,2,1,4,3,3,9,6,7,19]
	  
	 
	 Constraints:
	 
	 arr1.length, arr2.length <= 1000
	 0 <= arr1[i], arr2[i] <= 1000
	 Each arr2[i] is distinct.
	 Each arr2[i] is in arr1.
	 *
	 *
	 * 1.创建一个数组长度小于等于1001  = list
	 * 2. 将arr1循环放入到list中arr1中的值作为下标，value为出现的次数
	 * 3. 循环arr2，根据对应下标取出value,循环添加当前下标value次，然后将value赋值为0；
	 * 4.循环list，将value值不等于1的循环添加到数组末尾
	 */
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] list = new int[1001];
		for (int i = 0; i < arr1.length; i++) {
			list[arr1[i]]++;
		}
		int k = 0;
		for (int i = 0; i < arr2.length; i++) {
			int i1 = list[arr2[i]];
			for (int j = 0; j < i1; j++) {
				arr1[k] = arr2[i];
				k++;
			}
			list[arr2[i]] = 0;
		}
		for (int i = 0; i < list.length; i++) {
			int i1 = list[i];
			for (int j = 0; j < i1; j++) {
				arr1[k] = i;
				k++;
			}
		}
		
		return arr1;
	}
	
	public static void main(String[] args) {
		int[] ints = relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
			
		}
	}
}
