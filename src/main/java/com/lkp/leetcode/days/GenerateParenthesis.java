package com.lkp.leetcode.days;

import java.util.ArrayList;
import java.util.List;

/**
 *@className GenerateParenthesis
 *@description 22. 括号生成
 *@Auther 85291173@qq.com
 *@Date 2020/4/22 14:29
 *@Version
 */
public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		char[] chars = new char[2*n];
		List<String> list = new ArrayList<>();
		findAll(chars,0,list);
		return list;
	}
	
	private void findAll(char[] chars, int n, List<String> list) {
		
		if(n == chars.length){
			if(valid(chars)){
				list.add(new String(chars));
			}
			return;
		}
		chars[n] = '(';
		findAll(chars,n+1,list);
		chars[n] = ')';
		findAll(chars,n+1,list);
		
	}
	
	private boolean valid(char[] chars){
		int flag = 0 ;
		for (int i = 0; i < chars.length; i++) {
			if(flag < 0){
				return false;
			}
			if(chars[i] == '('){
				flag++;
			}
			if(chars[i] == ')'){
				flag--;
			}
		}
		return (flag == 0);
	}
	
}
