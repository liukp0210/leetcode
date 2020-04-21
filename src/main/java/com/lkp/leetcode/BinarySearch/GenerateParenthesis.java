package com.lkp.leetcode.BinarySearch;

import java.util.*;

/**
 *@className GenerateParenthesis
 *@description 22. 括号生成
 *@Auther 85291173@qq.com
 *@Date 2020/4/20 9:34
 *@Version
 */
public class GenerateParenthesis {
	public static List<String> generateParenthesis(int n) {
		List<String> combinations = new ArrayList();
		generateAll(new char[2 * n], 0, combinations);
		return combinations;
	}
	
	public static void generateAll(char[] current, int pos, List<String> result) {
		if (pos == current.length) {
			if (valid(current))
				result.add(new String(current));
		} else {
			current[pos] = '(';
			System.out.println("1:"+(pos+1));
			generateAll(current, pos+1, result);
			current[pos] = ')';
			System.out.println("2:"+(pos+1));
			generateAll(current, pos+1, result);
		}
	}
	
	public static boolean valid(char[] current) {
		int balance = 0;
		for (char c: current) {
			if (c == '(') balance++;
			else balance--;
			if (balance < 0) return false;
		}
		return (balance == 0);
	}
	
	
	public static void main(String[] args) {
		/**
		 * ()()()()
		 (()(()))
		 (()())()
		 ()()(())
		 (((())))
		 (())()()
		 ()((()))
		 ()(())()
		 ()(()())
		 (()()())
		 ((()()))
		 ((()))()
		 ((())())
		 */
		//["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
		List<String> generate = generateParenthesis(2);
		Iterator<String> iterator = generate.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
	
	
	public static List<String> generateParenthesis2(int n) {
		List<String> combinations = new ArrayList();
		generateAll2(new char[2 * n], 0, combinations);
		return combinations;
	}
	
	public static void generateAll2(char[] chars,int opt,List<String> combinations){
		
		if(opt == chars.length){
			if(valid2(chars)){
				combinations.add(new String(chars));
			}
		}else{
			chars[opt] = '(';
			generateAll2(chars,opt+1,combinations);
			chars[opt] = ')';
			generateAll2(chars,opt+1,combinations);
		}
		
		
	}
	
	public static boolean valid2(char[] chars){
		int temp = 0;
		for (int i = 0; i <chars.length  ; i++) {
			if(chars[i] == '('){
				temp++;
			}else{
				temp--;
			}
			if(temp < 0){
				return false;
			}
		}
		return (temp == 0);
	}
}
