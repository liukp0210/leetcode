package com.lkp.leetcode.hash;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@className LengthOfLongestSubstring
 *@description 3. 无重复字符的最长子串
 *@Auther 85291173@qq.com
 *@Date 2020/1/7 9:43
 *@Version
 */
 public class LengthOfLongestSubstring {
 	//pwwkew
//	bbbbb
//	abcabcbb
	public int lengthOfLongestSubstring(String s) {
		int count = 0;
		char[] chars = s.toCharArray();
		int i = 0;
		String str = "";
		while (i < chars.length){
			Character aChar = chars[i];
			
			if(!str.contains(aChar.toString())){
				str += aChar.toString();
			}else{
				count = Math.max(count,str.length());
				int i1 = str.indexOf(aChar.toString());
				if(i1 == str.length() - 1){
					
					str = aChar.toString();
				}else{
					str = str.substring(i1+1,str.length());
					str += aChar.toString();
				}
			}
			i++;
		}
		count = Math.max(count,str.length());
		return count;
	}
	
	public int lengthOfLongestSubstring2(String s){
		Set<Character> set = new HashSet<>();
		int ans = 0;
		int i = 0 ,j = 0;
		int length = s.length();
		while (i < length && j < length){
			char c = s.charAt(j);
			if(!set.contains(c)){
				set.add(c);
				j++;
				ans = Math.max(ans,j - i);
			}else{
				
				char c1 = s.charAt(i);
				set.remove(c1);
				i++;
			}
		}
		return  ans ;
	}
	
	
	
	//todo 未理解
	public int lengthOfLongestSubstring3(String s) {
		Map<Character, Integer> values = new HashMap<>();
		int left = 0;
		int maxLength = 0;
		
		for (int j=0; j<s.length(); j++)
		{
			char word = s.charAt(j);
			if (values.containsKey(word))
			{
				left = Math.max(values.get(word)+1, left);
			}
			values.put(word, j);
			maxLength = Math.max(maxLength, j-left+1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		LengthOfLongestSubstring l = new LengthOfLongestSubstring();
		int i = l.lengthOfLongestSubstring2("pwwkew");
		System.out.println(i);
	}
}
