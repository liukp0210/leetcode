package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className GroupAnagrams
 *@description 49. 字母异位词分组
 *@Auther 85291173@qq.com
 *@Date 2020/1/3 16:00
 *@Version
 */
public class GroupAnagrams {
	
	//[["buy"],["duh","ill"],["bar"],["cab"],["max"],["doc"],["may"],["tin"],["pew"]]
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String string = Arrays.toString(chars);
			boolean b = map.containsKey(string);
			List<String> list = null;
			if(b){
				list = map.get(string);
			}else{
				list = new ArrayList<>();
			}
			list.add(str);
			map.put(string,list);
		}
		List<List<String>> lists = new ArrayList<>();
		for (Map.Entry<String,List<String>> params:map.entrySet() ) {
			lists.add(params.getValue());
		}
		return lists;
	}
	public List<List<String>> groupAnagrams2(String[] strs) {
		if (strs.length == 0) return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) count[c - 'a']++;
			
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key)) ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}
}
