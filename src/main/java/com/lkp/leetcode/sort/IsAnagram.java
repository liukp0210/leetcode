package com.lkp.leetcode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *@className IsAnagram
 *@description Valid Anagram
 *@Auther 85291173@qq.com
 *@Date 2019/7/30 15:38
 *@Version
 */
public class IsAnagram {
	/**
	 * Given two strings s and t,write a function to dedermin if t is an anagram of s.
	 *Example 1:
	 
	 Input: s = "anagram", t = "nagaram"
	 Output: true
	 Example 2:
	 
	 Input: s = "rat", t = "car"
	 Output: false
	 Note:
	 You may assume the strings contains only lowercase alphabets.(假设这些字母全为小写字母)
	 * 思路：1.遍历字符串s，将每个值都放入到map中，key为当前字母 value为出现的次数
	 * 2. 遍历字符串t查看t中的每一个字符是否在map中，如果有将map中出现的次数减1，当map中次数等于0时，
	 * 删除map中的key值，当map中没有出现对应的值时，终止循环返回false,
	 * 3. 查看map中是否还有元素，如果有元素返回false;
	 *
	 */
	public static boolean isAnagram(String s,String t){
		Map<Character,Integer> map = new HashMap<>();
		/**
		 * 1.遍历字符串s，将每个值都放入到map中，key为当前字母 value为出现的次数
		 */
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))){
				Integer integer = map.get(s.charAt(i));
				map.put(s.charAt(i),++integer);
			}else{
				map.put(s.charAt(i),1);
			}
		}
		/**
		 * 2. 遍历字符串t查看t中的每一个字符是否在map中，如果有将map中出现的次数减1，当map中次数等于0时，
		 * 删除map中的key值，当map中没有出现对应的值时，终止循环返回false,
		 */
		for (int i = 0; i < t.length(); i++) {
			Character c = t.charAt(i);
			if(map.containsKey(c)){
				Integer integer = map.get(c);
				integer--;
				if(integer == 0){
					map.remove(c);
				}else{
					map.put(c,integer);
				}
				
			}else{
				return false;
			}
		}
		/**
		 * 查看map中是否还有元素，如果有元素返回false;
		 */
		Set<Character> characters = map.keySet();
		
		return characters.size()>0?false:true;
	}
	
	public static boolean isAnagram2(String s,String t){
		if(s.length() != t.length()){
			return false;
		}
		/**
		 * 共26个字母
		 */
		int[] arr = new int[26];
		for (int i = 0; i < s.length() ; i++) {
			arr[s.charAt(i)-'a']++;
			arr[t.charAt(i)-'a']--;
		}
		for (int num : arr ) {
			if(num != 0){
				return false;
			}
		}
		return true;
	}
	public static boolean isAnagram3(String s,String t){
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		Arrays.sort(chars);
		Arrays.sort(chart);
		return Arrays.equals(chars, chart);
	}
	public static void main(String[] args) {
		boolean anagram = isAnagram3("anagram", "nagaram");
		System.out.println(anagram);
	}
}
