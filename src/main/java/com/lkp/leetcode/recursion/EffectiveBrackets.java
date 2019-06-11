package com.lkp.leetcode.recursion;

import java.util.HashMap;
import java.util.Stack;

/**
 *@className EffectiveBrackets
 *@description 有效的括号
 *@Auther 85291173@qq.com
 *@Date 2019/6/10 9:39
 *@Version
 */
public class EffectiveBrackets {
	
	
	/**
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 有效字符串需满足：
	 左括号必须用相同类型的右括号闭合。
	 左括号必须以正确的顺序闭合。
	 注意空字符串可被认为是有效字符串。
	 示例 1:
	 输入: "()"
	 输出: true
	 示例 2:
	 输入: "()[]{}"
	 输出: true
	 示例 3:
	 输入: "(]"
	 输出: false
	 示例 4:
	 输入: "([)]"
	 输出: false
	 示例 5:
	 输入: "{[]}"
	 输出: true
	 *
	 */
	// Hash table that takes care of the mappings.
	private HashMap<Character, Character> mappings;
	
	// Initialize hash map with mappings. This simply makes the code easier to read.
	public EffectiveBrackets() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (this.mappings.containsKey(c)) {
				char topElement = stack.empty() ? '#' : stack.pop();
				if (topElement != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		EffectiveBrackets effectiveBrackets = new EffectiveBrackets();
//		boolean valid = effectiveBrackets.isValid(")[(]{}");
		boolean valid = isValid1("((");
		System.out.println(valid);
	}
	
	
	public static boolean isValid1(String str){
		if(str == null || str.equals("")){
			return true;
		}
		if(str.length()%2 != 0){
			return false;
		}
		HashMap<Character,Character> map = new HashMap<>();
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i <str.length() ; i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)){
				char c1 = stack.isEmpty() ? '#' : stack.pop();
				if(c1 != map.get(c)){
					return false;
				}
			}else{
				stack.push(c);
			}
			
		}
		
		return stack.isEmpty();
	}
	
}
