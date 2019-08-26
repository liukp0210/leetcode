package com.lkp.leetcode.test;

import java.util.*;

/**
 *@className RelativeSort
 *@description 数组的相对排序
 *@Auther 85291173@qq.com
 *@Date 2019/7/30 10:16
 *@Version
 */
 public class RelativeSort {
	
	/**
	 *
	 * 给你两个数组，arr1 和 arr2，
	 arr2 中的元素各不相同
	 arr2 中的每个元素都出现在 arr1 中
	 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
	 示例：
	 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	 输出：[2,2,2,1,4,3,3,9,6,7,19]
	 提示：
	 arr1.length, arr2.length <= 1000
	 0 <= arr1[i], arr2[i] <= 1000
	 arr2 中的元素 arr2[i] 各不相同
	 arr2 中的每个元素 arr2[i] 都出现在 arr1 中
	 *
	 *分析：1.将没有出现在arr2数组中的数据单独放入到一个集合中；然后对集合进行排序
	 * 2. 将出现在arr2数组中的数据放入到一个map中，key为arr2对应的值value为出现的次数
	 * 3. 循环map，将map中的key依次按照出现的次数添加到数组arr1中，添加完成之后将集合中未出现的数据依次排列在数组后面
	 *
	 *
	 */
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		/**
		 * 计算arr2在arr1中每次出现的次数
		 */
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if(arr2[i] == arr1[j]){
					if(map.containsKey(arr2[i])){
						Integer integer = map.get(arr2[i])+1;
						map.put(arr2[i],integer);
					}else{
						map.put(arr2[i],1);
					}
				}
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]){
					flag = true;
					continue;
				}
			}
			if(!flag){
				list.add(arr1[i]);
			}
			
		}
		list.sort((Integer o1,Integer o2) -> o1>o2?1:-1);
		List<Integer> integerList = new ArrayList<>();
		Set<Integer> set = map.keySet();
		for (Integer num:set) {
			Integer integer = map.get(num);
			for (int i = 0; i <integer ; i++) {
				integerList.add(num);
			}
		}
		integerList.addAll(list);
		for (int i = 0; i < integerList.size(); i++) {
			arr1[i] = integerList.get(i);
		}
		return arr1;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr1 =  new int[]{2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = new int[]{2,1,4,3,9,6};
		int[] ints = relativeSortArray2(arr1,arr2);
		for (int num :ints) {
			System.out.println(num);
		}
	}
	
	
	public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
		int[] m = new int[1001];
		
		int[] ref = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			m[arr1[i]]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < arr2.length; i++) {
			while(m[arr2[i]] > 0) {
				ref[cnt++] = arr2[i];
				m[arr2[i]]--;
			}
		}
		
		for(int i = 0; i < 1001; i++) {
			while(m[i] > 0) {
				ref[cnt++] = i;
				m[i]--;
			}
		}
		return ref;
	}
	
}
