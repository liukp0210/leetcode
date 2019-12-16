package com.lkp.leetcode.BinarySearch;

/**
 *@className NextGreatestLetter
 *@description 寻找比目标字母大的最小字母
 *@Auther 85291173@qq.com
 *@Date 2019/9/30 17:45
 *@Version
 */
public class NextGreatestLetter {
	/**
	 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
	 
	 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
	 
	 示例:
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "a"
	 输出: "c"
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "c"
	 输出: "f"
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "d"
	 输出: "f"
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "g"
	 输出: "j"
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "j"
	 输出: "c"
	 
	 输入:
	 letters = ["c", "f", "j"]
	 target = "k"
	 输出: "c"
	 
	 */
	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0 ;
		int right = letters.length -1 ;
		while (left <= right){
			int mid = (left + right)>>>1;
			if(letters[mid] == target){
				return letters[mid];
			}else if(letters[mid] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		if(left == letters.length -1  && letters[letters.length -1] <= target){
			return letters[0];
		}else{
			return letters[left];
		}
	}
}
