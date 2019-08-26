package com.lkp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@className RemoveOuterMostParentheses
 *@description 删除最外层括号
 *@Auther 85291173@qq.com
 *@Date 2019/8/23 17:08
 *@Version
 */
public class RemoveOuterMostParentheses {
	
	/**
	 *	A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
	 
	 A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
	 
	 Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
	 
	 Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
	 
	  
	 
	 Example 1:
	 
	 Input: "(()())(())"
	 Output: "()()()"
	 Explanation:
	 The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
	 After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
	 Example 2:
	 
	 Input: "(()())(())(()(()))"
	 Output: "()()()()(())"
	 Explanation:
	 The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
	 After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
	 Example 3:
	 
	 Input: "()()"
	 Output: ""
	 Explanation:
	 The input string is "()()", with primitive decomposition "()" + "()".
	 After removing outer parentheses of each part, this is "" + "" = "".
	  
	 
	 Note:
	 
	 S.length <= 10000
	 S[i] is "(" or ")"
	 S is a valid parentheses string
	 分析： 1. 循环字符串
	 		2. 创建两个栈，statck1 ,stack2
	 3. 如果字符为(并且stack1为空时放入stack1  ；
	 4. 如果字符为) 判断如果stack2是否为空，如果不为空取出拼接成字符串判断是否等于()，如果等于remove
	 5. 如果Stack2为空，则取出stack1中的值做对比；同时记录下标
	 */
	public static String removeOuterParentheses(String S) {
		String str = "";
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack12 = new Stack<>();
		List<Integer> list = new ArrayList<>();
		//(()())(())(()(()))
		for (int i = 0; i < S.length(); i++) {
			Character character = S.charAt(i);
			if(character == '('){
				if(stack1.isEmpty()){
					stack1.push(character);
					list.add(i);
				}else{
					stack12.push(character);
				}
			}else{
				if(!stack12.isEmpty()){
					String s =  stack12.peek().toString() + character.toString();
					if(s.equals("()")){
						stack12.pop();
					}else{
						stack12.push(character);
					}
				}else{
					String s = stack1.peek().toString() + character.toString();
					if(s.equals("()")){
						stack1.pop();
						list.add(i);
					}
				}
			}
		}
		for (int i = 0; i < S.length(); i++) {
			if(list.contains(i)){
				continue;
			}
			str += S.charAt(i);
		}
		return str;
	}
	
	
	/**
	 * 思路：使用stack，
	 * 为(左括号的时候入栈，如果栈为空记录当前下标
	 * 为)出栈，当栈为空时，表示为一个原语，记录当前下标，
	 * 截取字符串拼接到一起；
	 *
	 * @param S
	 * @return
	 */
	public static String removeOuterParentheses2(String S) {
		String str = "";
		Stack<Character> stack = new Stack<>();
		int start = 0;
		int end = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c == '('){
				if(stack.isEmpty()){
					start = i;
				}
				stack.push(c);
			}else{
				stack.pop();
				if(stack.isEmpty()){
					end = i;
				}
			}
			if(stack.isEmpty()){
				str += S.substring(start+1,end);
				start = 0 ;
				end = 0;
			}
		}
		
		return str;
	}
	public static String removeOuterParentheses3(String S) {
		char[] charArr = S.toCharArray();
		StringBuilder sb = new StringBuilder();
		int p_l = 0;
		int p_r = 0;
		for (int i = 0; i < charArr.length; i++) {
			if ('(' == charArr[i]) {
				p_l++;
			}
			if (')' == charArr[i]) {
				p_r++;
			}
			//找到原语
			if (p_l == p_r) {
				sb.append(S.substring(i - p_l * 2 + 2, i));
				p_l = 0;
				p_r = 0;
			}
		}
		return sb.toString();
		
	}
	public static void main(String[] args) {
		String s = removeOuterParentheses3("(()())(())");
		//"()()()()(())"
		System.out.println(s);
	}
}
