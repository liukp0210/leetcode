package com.lkp.leetcode.recursion;

/**
 *@className ReverseList
 *@description 翻转链表
 *@Auther 85291173@qq.com
 *@Date 2019/6/4 11:42
 *@Version
 */
public class ReverseList {
	
	/**
	 *
	 * 反转一个单链表。
	 示例:
	 输入: 1->2->3->4->5->NULL
	 输出: 5->4->3->2->1->NULL
	 *
	 */
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ this.val = x;}
	}
	
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		ListNode listNode1 = reverseList(listNode);
		
	}
	
	public static ListNode reverseList(ListNode head) {
		//前指针节点
		ListNode prev = null;
		//当前指针节点
		ListNode curr = head;
		//每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
		while (curr != null) {
			//临时节点，暂存当前节点的下一节点，用于后移
			ListNode nextTemp = curr.next;
			//将当前节点指向它前面的节点
			curr.next = prev;
			//前指针后移
			prev = curr;
			//当前指针后移
			curr = nextTemp;
		}
		return prev;
	}
}
