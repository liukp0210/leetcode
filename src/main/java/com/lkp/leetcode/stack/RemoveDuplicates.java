package com.lkp.leetcode.stack;

import java.util.Stack;

/**
 *@className RemoveDuplicates
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/26 16:59
 *@Version
 */
public class RemoveDuplicates {
	/**
	 * Remove All Adjacent Duplicaties In String
	 * Given a string S of lowercase letters,a duplicate removal consists of choosing two adjacent and
	 * equal letters ,and removing them.
	 * We repeatedly make duplicate removals on S until we no longer can.
	 * Return the final string after all such duplicate removals have been made.
	 * It is guaranteed the answer is unique.
	 *
	 * Example 1:
	 
	 Input: "abbaca"
	 Output: "ca"
	 Explanation:
	 For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
	 
	 Note:
	 1 <= S.length <= 20000
	 S consists only of English lowercase letters.
	 
	 思路：新建一个栈，循环字符串
	 2. 如果栈不为空时，取出栈顶的元素与当前元素对比；
	 3.如果相等，移除栈顶元素；
	 4. 如果不相等，将元素放入到栈中；
	 5.取出栈中的元素拼接成字符串
	 */
	public static String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(!stack.isEmpty()){
				Character peek = stack.peek();
				if(peek.equals(chars[i])){
					stack.pop();
				}else{
					stack.push(chars[i]);
				}
			}else{
				stack.push(chars[i]);
			}
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			Character character = stack.get(i);
			str.append(character);
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		removeDuplicates("abbaca");
	}
}
