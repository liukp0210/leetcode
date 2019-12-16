package com.lkp.leetcode.link;

import java.util.*;

/**
 *@className PalindRome
 *@description 回文链表
 *@Auther 85291173@qq.com
 *@Date 2019/9/17 14:37
 *@Version
 */
public class PalindRome {
	/**
	 * 请判断一个链表是否为回文链表。
	 示例 1:
	 输入: 1->2
	 输出: false
	 示例 2:
	 输入: 1->2->2->1
	 输出: true
	 *分析：
	 * 第一种：将链表反转，然后循环链表进行比较两个链表中的值是否相等
	 *
	 *1->2->3->2->1
	 *
	 * num = 0;
	 * num2 = 0;
	 * val = 1 num = 1
	 *
	 *
	 */
	
	/**
	 * 第一步，使用快慢指针查找链表中间点
	 * 第二部，反转链表前半部分
	 * 第三部，比较反转后的前半部分链表与后半部分链表是否相等
	 * @param head
	 * @return
	 */
	
	public boolean isPalindrome4(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		//第一步，使用快慢指针查找链表中间点
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		//反转链表前半部分
		ListNode pre = null;
		while (head != slow){
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		//判断链表个数是否为奇数，如果为奇数则将
		if(fast != null){
			slow = slow.next;
		}
		//比较反转后的前半部分链表与后半部分链表是否相等
		while (pre != null){
			if (slow.val != pre.val){
				return false;
			}
			slow = slow.next;
			pre = pre.next;
		}
		return true;
	}
	
	public boolean isPalindrome3(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new ArrayDeque<>();
		while (head != null){
			stack.push(head.val);
			queue.add(head.val);
			head = head.next;
		}
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			Integer pop = stack.pop();
			if (!next.equals(pop)){
				return false;
			}
			iterator.remove();
		}
		return true;
		
	}
	public boolean isPalindrome2(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new ArrayDeque<>();
		while (head != null){
			stack.push(head.val);
			queue.add(head.val);
			head = head.next;
		}
		Iterator<Integer> iterator = queue.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			Integer pop = stack.pop();
			if (!next.equals(pop)){
				return false;
			}
			iterator.remove();
		}
		return true;
		
	}
	public boolean isPalindrome(ListNode head) {
		ListNode node = head;
		ListNode listNode = new ListNode(-1);
		ListNode temp = listNode;
		while (node != null){
			temp.next = new ListNode(node.val);
			node = node.next;
			temp = temp.next;
		}
		ListNode listNode1 = reverseList(node);
		while (listNode1 != null) {
			if (listNode1.val != head.val ){
				return false;
			}
			listNode1 = listNode1.next;
			head = head.next;
		}
		return true;
		
	}
	
	public static ListNode reverseList(ListNode head){
		ListNode pre = null;
		ListNode temp = head;
		while (temp!= null){
			ListNode nextNode = temp.next;
			temp.next = pre;
			pre = temp;
			temp = nextNode;
		}
		
		return pre;
	}
	public static ListNode pushNode(int i){
		ListNode listNode = new ListNode(-1);
		ListNode temp = listNode;
		for (int j = 1; j <= i ; j++) {
			temp.next = new ListNode(j);
			temp = temp.next;
		}
		return listNode.next;
	}
	public static void main(String[] args) {
//		ListNode listNode1 = pushNode(5);
//		ListNode listNode = reverseList(listNode1);
//		while (listNode != null){
//			System.out.println(listNode.val);
//			listNode = listNode.next;
//		}
		PalindRome palindRome = new PalindRome();
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		palindRome.isPalindrome(listNode);
		
//		System.out.println(Integer.parseInt("12") == Integer.parseInt("21"));
	}
}
