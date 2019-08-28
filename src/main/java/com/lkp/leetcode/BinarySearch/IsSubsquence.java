package com.lkp.leetcode.BinarySearch;

/**
 *@className IsSubsquence
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/8/28 16:47
 *@Version
 */
 public class IsSubsquence {
	/**
	 *
	 * Given a string s and a string t , check if s is subsequence of t.
	 * You may assume that there is only lower case English letters in both s and t,t is potentially a very long(length~=500000)strings,
	 * and s is a short string (<=100).
	 * A subsquence of s string is a new string which is formed from the original string by deleting some(can be none)of the characters without
	 * disturbing the relative positions of the remaining characters (ie,"ace" is a subsequence of "abcde" while "aec" is not).
	 * Example 1:
	 * s = "abc",t = "ahbgdc"
	 * Return true.
	 * Example 2:
	 * s = "axc",t = "ahbgdc"
	 * return false.
	 * Follow up:
	 * If there are lots of incoming S,say S1,S2....SK where k >= 1B,and you want to check one by one to see if T has its subsequence.
	 * In this scenario,how would you change your code?
	 *
	 * 分析：使用while双层循环，定义 flag = false ; i = 0 ; j= i(需要顺序查找，排除前面的数据)
	 * 定义t为外层循环取出每次循环的 s.CharAt(i) 判断如果 flag == false 直接return false; 如果flag == true ,则 flag == false；并且i++
	 * 内层循环 t, 定义j=0,取出每次循环的 t.CharAt(i)
	 * 如果 t.CharAt(i) == s.CharAt(j)
	 * flag = true ;
	 *
	 * 并且跳出本次循环；
	 * else
	 * j++;
	 *
	 */
	public static boolean isSubsequence(String s, String t) {
		boolean flag = false;
		int i = 0;
		int j = i;
		while (i < s.length()){
			char c = s.charAt(i);
			while (j < t.length()){
				char c1 = t.charAt(j);
				if(c1 == c){
					flag = true;
				}
				j++;
				if(flag){
					break;
				}
			}
			if(flag){
				flag = false;
				i++;
			}else{
				return false;
			}
		}
		return true;
	}
	public static boolean isSubsequence2(String s, String t) {
		if(s.length()== 0){
			return true;
		}
		int i = 0;
		int j = 0;
		while (i < t.length()){
			char c = s.charAt(j);
			char c1 = t.charAt(i);
			if(c == c1){
				j++;
			}
			i++;
			//TODO 这块为s.length，因为 c==c1在最后一位时执行了++操作
			if(j == s.length()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * TODO 使用java内置函数查找对应的值
	 * indexOf(int ch, int fromIndex)
	 *  返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence3(String s, String t) {
		int index = -1;
		for (char c : s.toCharArray()){
			index = t.indexOf(c, index+1);
			if (index == -1) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "adc", t = "ahbgdc";
		boolean subsequence = isSubsequence2(s,t);
		System.out.println(subsequence);
	}
}
