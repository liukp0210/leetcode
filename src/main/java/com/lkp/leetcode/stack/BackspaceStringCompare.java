package com.lkp.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 *@className BackspaceStringCompare
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/23 16:47
 *@Version
 */
public class BackspaceStringCompare {
	/**
	 * Give two strings S and T,return if they are equal when both are typed into empty text editors . # means a backspace character.
	 *
	 *Example 1:
	 
	 Input: S = "ab#c", T = "ad#c"
	 Output: true
	 Explanation: Both S and T become "ac".
	 Example 2:
	 
	 Input: S = "ab##", T = "c#d#"
	 Output: true
	 Explanation: Both S and T become "".
	 Example 3:
	 
	 Input: S = "a##c", T = "#a#c"
	 Output: true
	 Explanation: Both S and T become "c".
	 Example 4:
	 
	 Input: S = "a#c", T = "b"
	 Output: false
	 Explanation: S becomes "c" while T becomes "b".
	 Note:
	 
	 1 <= S.length <= 200
	 1 <= T.length <= 200
	 S and T only contain lowercase letters and '#' characters.
	 * 分析： 分别循序S,T两个字符串，将他们放入到两个stack中，如果中间出现#则表示回退，移除stack顶部元素,
	 * 在出现#时判断stack中是否有数据，如果没有则不用移除，以免报错
	 * 如果两个stackc长度不一致直接返回fasle,比较两个stack中的元素;
	 * 最后判断栈中都为空则返回true
	 *
	 */
	
	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> stackS = new Stack<>();
		Stack<Character> stackT = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if(c.equals('#')){
				if(!stackS.isEmpty() && stackS.size() > 0){
					stackS.pop();
				}
			}else{
				stackS.push(c);
			}
		}
		
		for (int i = 0; i < T.length(); i++) {
			Character c = T.charAt(i);
			if(c.equals('#')){
				if(!stackT.isEmpty() && stackT.size() > 0){
					stackT.pop();
				}
			}else{
				stackT.push(c);
			}
		}
		if(stackT.size() != stackS.size()){
			return false;
		}
		while (stackT.size() > 0){
			Character character = stackT.pop();
			Character character1 = stackS.pop();
			if(!character.equals(character1) ){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		
		boolean b = backspaceCompare("ab#c", "ad#c");
		System.out.println(b);
	}
}
