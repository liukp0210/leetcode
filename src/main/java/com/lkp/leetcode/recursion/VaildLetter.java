package com.lkp.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 *@className VaildLetter
 *@description 有效数字
 *@Auther 85291173@qq.com
 *@Date 2019/6/4 17:36
 *@Version
 */
 public class VaildLetter {
	
	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 示例 1:
	 输入: s = "anagram", t = "nagaram"
	 输出: true
	 示例 2:
	 输入: s = "rat", t = "car"
	 输出: false
	 说明:
	 你可以假设字符串只包含小写字母。
	 *
	 * 解题：1.循环s，t取出里面字符串放入两个map，将字符串对应出现的次数作为字母作为key出现次数作为value
	 * 对比两个map
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		Map<String,Integer> smap = new HashMap<>();
		Map<String,Integer> tmap = new HashMap<>();
		for (int i = 0; i < s.length() ; i++) {
			Integer integer = smap.get(s.substring(i,i+1));
			if(integer != null){
				integer += 1;
			}else{
				integer = 1;
			}
			smap.put(s.substring(i,i+1),integer);
			Integer integer2 = tmap.get(t.substring(i,i+1));
			if(integer2 != null){
				integer2 += 1;
			}else{
				integer2 = 1;
			}
			tmap.put(t.substring(i,i+1),integer2);
		}
		for (String character:smap.keySet()){
			Integer a = smap.get(character);
			Integer b = tmap.get(character);
			if( !a.equals(b) ){
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		int[] alpha = new int[26];
		for(int i = 0; i< s.length(); i++) {
			alpha[s.charAt(i) - 'a'] ++;
			alpha[t.charAt(i) - 'a'] --;
		}
		for(int i=0;i<26;i++){
			if(alpha[i] != 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		boolean anagram = isAnagram("aacc", "ccac");
		System.out.println(anagram);
	}
}
