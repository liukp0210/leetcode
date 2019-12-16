package com.lkp.leetcode.link;

import java.util.List;

/**
 *@className ReverseList
 *@description 反转链表
 *@Auther 85291173@qq.com
 *@Date 2019/9/17 11:44
 *@Version
 */
 public class ReverseList {
	
	/**
	 * 反转一个单链表。
	 示例:
	 输入: 1->2->3->4->5->NULL
	 输出: 5->4->3->2->1->NULL
	 * 1
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode listNode = new ListNode(-1);
		ListNode temp = listNode;
		while (head != null){
			if ( temp.next == null) {
				temp.next = new ListNode(head.val);
			}else{
				ListNode A = temp.next;
				temp.next = new ListNode(head.val);
				temp.next.next  = A;
			}
			head = head.next;
		}
		return temp.next;
	}
	public static ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode temp = head;
		while (temp != null){
			ListNode nextNode = temp.next;
			temp.next = pre;
			pre = temp;
			temp = nextNode;
		}
		return pre;
	}
	
	
	
	
	
	public static ListNode reverseList3(ListNode head) {
		ListNode prev = null;
		ListNode curr = head; //当前指针节点
		//每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
		while (curr != null) {
			ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
			curr.next = prev; //将当前节点指向它前面的节点
			prev = curr; //前指针后移
			curr = nextTemp; //当前指针后移
		}
		return prev;
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
		ListNode listNode1 = pushNode(5);
		ListNode listNode = reverseList2(listNode1);
		while (listNode != null){
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}
