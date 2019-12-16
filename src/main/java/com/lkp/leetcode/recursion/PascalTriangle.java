package com.lkp.leetcode.recursion;

import com.lkp.leetcode.test.ReverseList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@className PascalTriangle
 *@description 帕斯卡三角形
 *@Auther 85291173@qq.com
 *@Date 2019/10/9 18:24
 *@Version
 */
public class PascalTriangle {
	public  void reverseString(char[] s) {
		if(s == null || s.length == 0 ){
			return;
		}
		int i = 0 ;
		reverseArr(s,i);
	}
	public void reverseArr(char[] s ,int i ){
		int i1 = s.length >> 1;
		System.out.println(i1);
		if(i < i1 ){
			char temp = s[i];
			s[i] = s[s.length-1-i];
			s[s.length-1-i] = temp;
			reverseArr(s,++i);
		}
	}
//	public static void main(String[] args) {
//		char[] chars = new char[]{'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
//		char[] chars = new char[]{'h','e','l','c','o','a'};
//		PascalTriangle pascalTriangle = new PascalTriangle();
//		pascalTriangle.reverseString(chars);
//		String s = Arrays.toString(chars);
//		System.out.println(s);
//		ReverseList.ListNode head = new ReverseList.ListNode(1);
//		head.next = new ReverseList.ListNode(2);
//		head.next.next = new ReverseList.ListNode(3);
//		head.next.next.next = new ReverseList.ListNode(4);
//		swapPairs(head);
//		List<List<Integer>> generate = generate(5);
//		System.out.println(generate.toString());
//		List<Integer> row = getRow(4);
//		System.out.println(row.toString());
//	}
	
	//给定 1->2->3->4, 你应该返回 2->1->4->3.
	public static ReverseList.ListNode swapPairs(ReverseList.ListNode head) {
		if (head != null && head.next != null){
			ReverseList.ListNode temp = head.next;
			ReverseList.ListNode tempNext = head.next.next;
			temp.next = head;
			temp.next.next = tempNext;
			head = temp;
			ReverseList.ListNode listNode = swapPairs(head.next.next);
			head.next.next = listNode;
		}
		return head;
	}
	
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> lists = new ArrayList<>();
		if(numRows <= 0 ){
			return lists;
		}
		List<Integer> arr = new ArrayList<>();
		if(numRows > 1){
			List<List<Integer>> generate = null;
			arr.add(1);
			generate = generate(numRows-1);
			for (int i = 1; i < numRows-1; i++) {
				List<Integer> list = generate.get(numRows-2);
				Integer integer = list.get(i - 1);
				Integer integer1 = list.get(i );
				arr.add(integer+integer1);
			}
			arr.add(1);
			lists.addAll(generate);
			lists.add(arr);
		}else{
			arr.add(1);
			lists.add(arr);
		}
		return lists;
	}
	
	public  static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		if(rowIndex < 0){
			return list;
		}
		if(rowIndex  > 0){
			list.add(1);
			List<Integer> row = getRow(rowIndex - 1);
			for (int i = 1; i < rowIndex  ; i++) {
				Integer integer = row.get(i);
				Integer integer1 = row.get(i - 1);
				int i1 = integer1 + integer;
				list.add(i1);
			}
			list.add(1);
		}else{
			list.add(1);
		}
		return list;
	}
	
	/**
	 * 输入: 1->2->3->4->5->NULL
	 	输出: 5->4->3->2->1->NULL
	 * @param head
	 * @return
	 */
	public ReverseList.ListNode reverseList(ReverseList.ListNode head) {
		ReverseList.ListNode pre = null;
		ReverseList.ListNode temp = head;
		while (temp != null){
			ReverseList.ListNode next = temp.next;
			temp.next = pre;
			pre = temp ;
			temp = next;
		}
		
		return pre;
	}
	public static ReverseList.ListNode reverseList1(ReverseList.ListNode head) {
		if( head == null || head.next == null){
			return head;
		}
		ReverseList.ListNode listNode = reverseList1(head.next);
		head.next.next = head;
		head.next = null;
		return listNode;
	}
	
//	public static void main(String[] args) {
//		ReverseList.ListNode head = new ReverseList.ListNode(1);
//		head.next = new ReverseList.ListNode(2);
//		head.next.next = new ReverseList.ListNode(3);
//		head.next.next.next = new ReverseList.ListNode(4);
//		head.next.next.next.next = new ReverseList.ListNode(5);
//		ReverseList.ListNode listNode = reverseList1(head);
//		int fib = climbStairs(45);
//		System.out.println(fib);
//	}
//
	
	public  static int fib(int N) {
		if(N < 2){
			return N;
		}
		return fib(N-1) + fib(N-2);
	}
	
	static HashMap<Integer,Integer> cache = new HashMap<>();
	/**
	 * 爬楼梯 f(2) =
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(cache.containsKey(n)){
			Integer integer = cache.get(n);
			return integer;
		}
		if(n < 3){
			return n;
		}
		int i = climbStairs(n - 1) + climbStairs(n - 2);
		cache.put(n,i);
		return i;
	}
	
	/**
	 * 输入：1->2->4, 1->3->4
	  输出：1->1->2->3->4->4
	 * @param l1
	 * @param l2
	 * @return
	 */
	//双指针
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode(-1);
		ListNode temp = resultNode;
		while (l1 != null && l2 != null){
			if(l1.val > l2.val){
				temp.next = l2;
				l2 = l2.next;
			}else{
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		if(l1 != null){
			temp.next = l1;
		}else{
			temp.next = l2;
		}
		return resultNode.next;
	}
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode resNode = new ListNode(-1);
		if(l1.val >  l2.val){
			resNode.next = l2;
			resNode.next.next = mergeTwoLists2(l1,l2.next);
		}else{
			resNode.next = l1;
			resNode.next.next = mergeTwoLists2(l1.next,l2);
		}
		return resNode.next;
	}
	
	public static int kthGrammar(int N, int K) {
		String dikgefuhao = dikgefuhao2(N).toString();
		System.out.println(dikgefuhao);
		int a = 0 ;
//		if(dikgefuhao.length() >= K){
//			String c = dikgefuhao.substring(K - 1,K);
//			a = Integer.parseInt(c);
//		}
		return a;
	}
	
	public static StringBuilder dikgefuhao2(int n){
		if(n ==  2){
			return new StringBuilder("01");
		}else{
			StringBuilder a = new StringBuilder();
			StringBuilder s = dikgefuhao2(--n);
			
			a.append(s);
			a.append(s.reverse());
			System.out.println(a.toString());
			return s;
		}
		
	}
	public static String dikgefuhao(int n){
		if(n <=  1){
			return "0";
		}else{
			
			String dikgefuhao = dikgefuhao(--n);
			String str = "";
			for (int i = 0; i < dikgefuhao.length(); i++) {
				char c = dikgefuhao.charAt(i);
				if(c == '0'){
					str += "01";
				}else{
					str += "10";
				}
			}
			return str;
		}
		
	}
	
	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(4);
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
//		ListNode listNode = mergeTwoLists2(l1, l2);
//		System.out.println(listNode);
		int i = kthGrammar(4, 1);
//		System.out.println(i);
	}
	
	public int kthGrammar3(int N, int K) {
		if (N == 1) return 0;
		return (~K & 1) ^ kthGrammar3(N-1, (K+1)/2);
	}
	
	public int kthGrammar4(int N, int K) {
		if (N == 1) return 0;
		if (K <= 1 << N-2)
			return kthGrammar4(N-1, K);
		return kthGrammar4(N-1, K - (1 << N-2)) ^ 1;
	}
	public int kthGrammar5(int N, int K) {
		return Integer.bitCount(K - 1) % 2;
	}
	public static class TreeNode{
		int val;
		com.lkp.leetcode.recursion.TreeNode left;
		com.lkp.leetcode.recursion.TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * 如果它的左子树不为空，则左子树上所有节点的值均小于它的根节点
	 * 如果它的右子树不为空，则右子树上所有的节点值均大于它的跟节点值
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
		for (int i = 1; i < n; i++) {
			generateTrees(i);
		}
		return null;
	}
	//3
	public TreeNode generateTree(int n) {
		TreeNode treeNode = new TreeNode(n);
		
		
		return null;
	}
	
}


class  ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}
}


