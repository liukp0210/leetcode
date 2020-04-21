package com.lkp.leetcode.hash;

import java.util.*;

/**
 *@className RandomizedSet
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2020/1/10 11:35
 *@Version
 */
public class RandomizedSet {
	List<Integer> list = null;
	Map<Integer,Integer> map = null;
	Random random = new Random();
	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)){
			return false;
		}
		map.put(val,list.size());
		list.add(list.size(),val);
		return true;
	}
	
	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)){
			return false;
		}
		Integer lastVal = list.get(list.size()-1);
		Integer index = map.get(val);
		list.set(index,lastVal);
		map.put(lastVal,index);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}
	
	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
	
	public static void main(String[] args)
	{
//		RandomizedSet randomizedSet = new RandomizedSet();
//		randomizedSet.insert(1);
//		randomizedSet.remove(2);
//		randomizedSet.insert(2);
//		int random = randomizedSet.getRandom();
//		System.out.println(random);
//		randomizedSet.remove(1);
//		randomizedSet.insert(2);
//		random = randomizedSet.getRandom();
//		System.out.println(random);
		for (int i = 0; i < 10; i++) {
			
			Random random = new Random();
			int j = random.nextInt(Integer.MAX_VALUE);
			int i1 = j % 1;
			System.out.println(i1);
		}
	}
}
