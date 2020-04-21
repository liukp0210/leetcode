package com.lkp.leetcode.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@className OriginalDigits
 *@description 从英文中重建数字
 *@Auther 85291173@qq.com
 *@Date 2019/11/19 9:19
 *@Version
 */
public class OriginalDigits {
	
	/**
	 * 0 zero
	 * 1 one
	 * 2 two
	 * 3 three
	 * 4 four
	 * 5 five
	 * 6 six
	 * 7 seven
	 * 8 eight
	 * 9 nine
	 *
	 * @param s
	 * @return
	 */
	
	public static void main(String[] args) {
		String str = originalDigits("owoztneoer");
		System.out.println(str);
//		str = getString(str, list, ints);
//		System.out.println(Arrays.toString(ints));
//		System.out.println(str);
	}
	public static String originalDigits(String s) {
		int[] countArr = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i <chars.length; i++) {
			countArr[chars[i]-'a']++;
		}
		int[] out = new int[10];
//		0 2 4 6 8 1 3 5 7 9
		out[0] =  countArr['z'-'a'];
		out[2] =  countArr['w'-'a'];
		out[4] =  countArr['u'-'a'];
		out[6] =  countArr['x'-'a'];
		out[8] =  countArr['g'-'a'];
		out[1] =  countArr['o'-'a'] -out[0] -out[2]-out[4];
		out[3] =  countArr['h'-'a'] -out[8];
		out[7] =  countArr['s'-'a'] -out[6];
		out[5] =  countArr['v'-'a'] -out[7];
		out[9] =  countArr['i'-'a'] -out[5] -out[6]-out[8];
		StringBuilder output = new StringBuilder();
		for (int i = 0; i <out.length ; i++) {
			for (int j = 0; j < out[i]; j++) {
				output.append(i);
			}
			
		}
		return output.toString();
	}
	
	
	/**
	 *
	 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
	 
	 注意:
	 
	 输入只包含小写英文字母。
	 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
	 输入字符串的长度小于 50,000。
	 示例 1:
	 输入: "owoztneoer"
	 输出: "012" (zeroonetwo)
	 
	 示例 2:
	 输入: "fviefuro"
	 输出: "45" (fourfive)
	 
	 *
	 * 1.定义一个数组[26]将字符串对应的ascll表的值-a放入到数组中将对应的数组中的值进行++操作
	 *
	 *
	 */
	public static int[] checkNum(String src){
		int[] arr = new int[26];
		for (int i = 0; i < src.length(); i++) {
			int i1 = src.charAt(i) - 'a';
			arr[i1] = arr[i1]+1;
		}
		return arr;
	}
	
	public static boolean findNum(int[]  a ,String num) {
		int[] indexarr = new int[num.length()];
		int k = 0;
		for (int i = 0; i < num.length(); i++) {
			int i1 = num.charAt(i) - 'a';
			int i2 = a[i1];
			if(i2 > 0){
				indexarr[k] = i1;
				k++;
			}else{
				break;
				
			}
		}
		if(k == num.length()){
			for (int i = 0; i < k; i++) {
				int i1 = indexarr[i];
				a[i1]--;
			}
			return true;
		}
		return false;
	}
	
	
	private static String getString(String str, List<String> list, int[] ints) {
		int i = 0 ;
		while (i < list.size()){
			boolean num = findNum(ints, list.get(i));
			if(num){
				str += i;
			}
			i++;
		}
		for (int j = 0; j <ints.length ; j++) {
			if(ints[j] != 0 ){
				return  getString(str, list, ints);
			}
			
		}
		return str;
	}
}
