package com.lkp.leetcode.str;

import java.util.*;

/**
 *@className Main
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/11/8 17:50
 *@Version
 */
 public class Main {
	public static void main01(String[] args) {
		String s1 = "Hello World";
//		s1[5] = ',';
		System.out.println(s1);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		boolean palindrome = isPalindrome(head);
		System.out.println(palindrome);
	}
	
	public static boolean isPalindrome(ListNode head) {
		if(head == null){
			return false;
		}
		if(head.next == null){
			return true;
		}
		ListNode pre = null;
		ListNode curr = head;
		int i = 0 ;
		while (curr != null){
			ListNode next = curr.next;
			if(next == null){
				break;
			}else if(curr.val < next.val ){
				curr.next = pre;
				pre = curr;
				curr = next;
				i++;
			}
		}
		if(i%2 != 0){
			curr = curr.next;
		}
		while (curr != null && pre != null){
			if (curr.val == pre.val ) {
				return false;
			}
			curr = curr.next;
			pre = pre.next;
		}
		return pre== null&&curr==null?true:false;
	}
	public ListNode oddEvenList(ListNode head) {
		ListNode  odd = head;
		ListNode eventHead = head.next;
		ListNode event = eventHead;
		while (event != null && event.next != null){
			odd.next = event.next;
			odd = odd.next;
			event.next =  odd.next;
			event = event.next;
		}
		odd.next = event.next;
		return head;
	}
	
	
  
	public String addBinary(String a ,String b){
		StringBuilder str = new StringBuilder();
		int max = Math.max(a.length(), b.length());
		int alength = a.length();
		int blength = b.length();
		while (max >= 0){
			if(alength >= 0){
			
			}
			if(blength >= 0){
			
			}
		}
		return null;
	}
	
	
	/**
	 * n表示二进制数据长度 数据的取值范围为(0 <= start <= 2^n-1)
	 * 2^n-1 则这个二进制说所有位上都为1
	 * start %2 == 1 表示为奇数
	 * todo
	 * @param n
	 * @param start
	 * @return
	 */
	public static List<Integer> circularPermutation(int n, int start) {
		List<Integer> list = buildList(n);
		List<Integer> resList = new ArrayList<>();
		System.out.println(Arrays.toString(list.toArray()));
		int k = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(start)){
				k = i;
				break;
			}
		}
		resList.addAll(list.subList(k,list.size()));
		resList.addAll(list.subList(0,k));
		return resList;
		
	}
	
	private static List<Integer> buildList(int n){
		
		if(n == 1){
			List<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(1);
			return list;
		}
		List<Integer> list1 = buildList(n - 1);
		List<Integer> resList = new ArrayList<>();
		int m = 1;
		while (n-->1){
			m*=2;
		}
		resList.addAll(list1);
		for (int i = 1; i <= list1.size(); i++) {
			resList.add(list1.get(list1.size()-i)+m);
		}
		
		return resList;
	}
	
	
	/**
	 *
	 * start s 为起始位置
	 * 1.计算起始位置 左边一位 start<<1|start
	 *2. 计算起始位置 右边一位
	 *  
	 
	 示例 1：
	 
	 输入：n = 2, start = 3
	 输出：[3,2,0,1]
	 解释：这个排列的二进制表示是 (11,10,00,01)
	 所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
	 示例 2：
	 
	 输出：n = 3, start = 2
	 输出：[2,6,7,5,4,0,1,3]
	 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
	 
	 */
	// 代码的写法还可以优化，思路如此：
	public static List<Integer> circularPermutation2(int n, int start) {
		List<Integer> list = build(n);
		List<Integer> res = new ArrayList<>(list.size());
		int i = 0;
		for(;i<list.size();i++) {
			if(list.get(i).equals(start)) {
				break;
			}
		}
		res.addAll(list.subList(i, list.size()));
		res.addAll(list.subList(0, i));
		return res;
	}
	
	private static List<Integer> build(int n){
		if(n==1) {
			List<Integer> list = new ArrayList<>();
			list.add(0);
			list.add(1);
			return list;
		}
		List<Integer> old = build(n-1);
		int size = old.size();
		List<Integer> res = new ArrayList<>(size * 2);
		int m = 1;
		while(n-->1) {
			m*=2;
		}
		res.addAll(old);
		
		for(int i=1;i<=old.size();i++) {
			res.add(res.get(size-i)+m);
		}
		return res;
	}
	
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}