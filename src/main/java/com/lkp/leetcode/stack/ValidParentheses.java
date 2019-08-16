package com.lkp.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *@className ValidParentheses
 *@description valid parentheses(有效的括号)
 *@Auther 85291173@qq.com
 *@Date 2019/8/5 17:23
 *@Version
 */
public class ValidParentheses {
	
	/**
	 *
	 * Given s string containing just the characters (){}[],determine if the input string is valid.
	 * An input string is valid if:
	 *		1.Open brackets must be closed by the same type of brackedts.
	 *		2.Open brackets must be closed in the correct order.
	 * Note that an empty string is also considered valid.
	 * @param s
	 * @return
	 *
	 * Example 1:
	
	Input: "()"
	Output: true
	Example 2:
	
	Input: "()[]{}"
	Output: true
	Example 3:
	
	Input: "(]"
	Output: false
	Example 4:
	
	Input: "([)]"
	Output: false
	Example 5:
	
	Input: "{[]}"
	Output: true
	
	 */
	public static boolean isValid(String s) {
		if(s.length()%2 != 0){
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++ ) {
			Character c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{'  ){
				stack.push(c);
			}else{
				if(stack.size() <= 0){
					return false;
				}
				Character pop = stack.pop();
				if(pop == null){
					return false;
				}
				String s1 = pop.toString() + c.toString();
				if(!s1.equals("()") && !s1.equals("[]") && !s1.equals("{}") ){
					return false;
				}
			}
		}
		
		return stack.size() == 0?true:false;
	}
	public static boolean isValid2(String s) {
		if(s.length()%2 != 0){
			return false;
		}
		Map<Character,Character> map = new HashMap<>();
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++ ) {
			Character c = s.charAt(i);
			if(!map.containsKey(c)){
				stack.push(c);
			}else{
				if(stack.size() <= 0){
					return false;
				}
				Character pop = stack.pop();
				if(!map.get(c).equals(pop )){
					return false;
				}
			}
		}
		return stack.size() == 0?true:false;
	}
	
	public static void main(String[] args) {
		boolean valid = isValid2("([)]");
		System.out.println(valid);
	}
}
