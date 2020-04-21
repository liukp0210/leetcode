package com.lkp.leetcode.days;

import sun.security.krb5.internal.PAForUserEnc;

import java.util.HashMap;
import java.util.Map;

/**
 *@className MyAtoi
 *@description 8.字符串转换整数
 *@Auther 85291173@qq.com
 *@Date 2020/4/20 15:31
 *@Version
 */
public class MyAtoi {
	
	public static int myAtoi(String str) {
		if(null == str ||str.trim() == "" ){
			return 0;
		}
		int symbol = 1;
		Long result = 0L;
		str = str.trim();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(i == 0 ){
				if(c == '-'){
					symbol = -1;
					continue;
				}
				if(c == '+'){
					continue;
				}
			}
			if(result >= Integer.MAX_VALUE){
				break;
			}
			if(c >= '0' && c <= '9'){
				result = result * 10 + c-48;
			}else{
				break;
			}
		}
		if(result*symbol >= Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(result*symbol <= Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		
		return (int) (result*symbol);
	}
	
	public static void main(String[] args) {
		int i = myAtoi("9223372036854775808");
		System.out.println(i);
	}
	public int myAtoi2(String str) {
		Automaton automaton = new Automaton();
		for (int i = 0; i < str.length(); i++) {
			if(automaton.getFlag()){
				automaton.getInteger(str.charAt(i));
			} else {
				break;
			}
		}
		return automaton.getResult();
	}
	
	enum DFA{
		START,
		SIGNED,
		NUMBER,
		END;
	}
	
	class Automaton{
		//自动装配初始状态
		private DFA state = DFA.START;
		
		//记录状态流转
		private Map<DFA,DFA[]> map;
		
		//记录符号位
		private char sign = '+';
		
		//记录结果
		private int result = 0 ;
		
		//判断终止条件
		private boolean flag = true;
		
		public Automaton(){
			map = new HashMap<>();
			map.put(DFA.START,new DFA[]{DFA.START,DFA.SIGNED,DFA.NUMBER,DFA.END});
			map.put(DFA.SIGNED,new DFA[]{DFA.END,DFA.END,DFA.NUMBER,DFA.END});
			map.put(DFA.NUMBER,new DFA[]{DFA.END,DFA.END,DFA.NUMBER,DFA.END});
			map.put(DFA.END,new DFA[]{DFA.END,DFA.END,DFA.END,DFA.END});
		}
		public int getResult() {
			return result;
		}
		
		public boolean getFlag() {
			return flag;
		}
		// 处理状态变化
		public int getIndex(char c) {
			if (c == ' ') return 0;
			if (c == '+' || c == '-') return 1;
			if (c >= '0' && c <= '9') return 2;
			return 3;
		}
		
		//计算当前结果
		public void getInteger(char c){
			//跟踪当前状态
			state = map.get(state)[getIndex(c)];
			switch (state){
				case NUMBER:
					if(sign == '+' && (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && c - '0' > 7))){
						result = Integer.MAX_VALUE;
						flag = false;
						break;
					}else if(sign == '-' && (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && c - '0' > 8))){
						result = Integer.MIN_VALUE;
						flag = false;
						break;
					}
					result = (sign == '+')?(result * 10 + c- '0'):(result * 10 - (c-'0'));
					break;
				case SIGNED:
					sign = c;
					break;
				case END:
					flag = false;
					break;
					default:
						break;
			}
		}
		
	}
	
}
