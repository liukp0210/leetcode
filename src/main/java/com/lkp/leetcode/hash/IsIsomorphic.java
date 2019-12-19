package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className UsIsomorphic
 *@description 205. 同构字符串
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 17:50
 *@Version
 */
public class IsIsomorphic {
	
	/**
	 *
	 *
	 *1.先找到重复的值，以及对应的下标
	 *2. 判断s,t重复值的下标是否一样如果一样则为true
	 *
	 *
	 */
	public boolean isIsomorphic(String s, String t) {
		LinkedHashMap<Character,ArrayList<Integer>> listLinkedHashMap =  new LinkedHashMap<>();
		LinkedHashMap<Character,ArrayList<Integer>> listLinkedHashMapT =  new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(listLinkedHashMap.containsValue(c)){
				listLinkedHashMap.get(c).add(i);
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				listLinkedHashMap.put(c,list);
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(listLinkedHashMapT.containsValue(c)){
				listLinkedHashMapT.get(c).add(i);
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				listLinkedHashMapT.put(c,list);
			}
		}
		if(listLinkedHashMap.size() != listLinkedHashMapT.size()){
			return false;
		}
		Set<Character> characters = listLinkedHashMap.keySet();
		Set<Character> characterT = listLinkedHashMapT.keySet();
		Iterator<Character> iterator = characters.iterator();
		Iterator<Character> iteratorT = characterT.iterator();
		boolean flag = true;
		while (iterator.hasNext() && iteratorT.hasNext()){
			Character character = iterator.next();
			ArrayList<Integer> list = listLinkedHashMap.get(character);
			Character charT = iteratorT.next();
			ArrayList<Integer> listT = listLinkedHashMapT.get(charT);
			if(!isEquals(list,listT)){
				return false;
			}
		}
		if(flag ){
			return true;
		}
		return false;
	}
	public static boolean isEquals(List<Integer> list1,List<Integer> list2){
		if(null != list1 && null != list2){
			if(list1.containsAll(list2) && list2.containsAll(list1)){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public boolean isIsomorphic2(String s, String t) {
		Map m = new HashMap();
		for (Integer i=0; i<s.length(); ++i)
			if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i))
				return false;
		return true;
	}
	
	public boolean isIsomorphic3(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		
		HashMap<Character, Character> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			if(!map.containsKey(s.charAt(i))){
				if(map.containsValue(t.charAt(i))){
					return false;
				}
				map.put(s.charAt(i), t.charAt(i));
			}else{
				if(map.get(s.charAt(i))!=t.charAt(i)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean isIsomorphic5(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) return false;
		}
		return true;
	}
	
	public boolean isIsomorphic6(String s, String t) {
		Map<Character,Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))){
				
				if(map.get(s.charAt(i)) != t.charAt(i)){
					return false;
				}
			}else{
				if(map.containsValue(t.charAt(i))){
					return false;
				}
				map.put(s.charAt(i),t.charAt(i));
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		IsIsomorphic a = new IsIsomorphic();
		boolean isomorphic = a.isIsomorphic("abc", "cdd");
		System.out.println(isomorphic);
	}
}
