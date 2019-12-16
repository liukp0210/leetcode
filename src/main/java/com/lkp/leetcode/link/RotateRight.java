package com.lkp.leetcode.link;

/**
 *@className RotateRight
 *@description 61. 旋转链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 16:27
 *@Version
 */
public class RotateRight {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null){
			return  null;
		}
		if(head.next == null){
			return  head;
		}
		int size = 0;
		ListNode temp = head;
		while (temp != null){
			temp = temp.next;
			size++;
		}
		k = k%size;
		if(k==0){
			return head;
		}
		int index = size - k;
		ListNode pre = head;
		temp = head.next;
		int i = 1 ;
		while (temp != null){
			if(i == index){
				pre.next = null;
				break;
			}
			i++;
			pre = pre.next;
			temp = temp.next;
		}
		ListNode tempA = temp;
		ListNode next = temp.next;
		while (next != null){
			next = next.next;
			tempA = tempA.next;
		}
		tempA.next = head;
		return temp;
	}
	public ListNode rotateRight2(ListNode head, int k) {
		if(head==null||head.next==null) return head;
		ListNode p = head;
		int count = 1;
		while(p.next!=null){
			p = p.next;
			count++;
		}
		k = count - k%count;
		p.next = head;
		while(k>0){
			p = p.next;
			k--;
		}
		ListNode result = p.next;
		p.next = null;
		return result;
	}
	public static ListNode rotateRight3(ListNode head, int k) {
		if(head==null||head.next==null) return head;
		int count = 1;
		ListNode temp = head;
		while (temp.next != null){
			count++;
			temp = temp.next;
		}
		k = count - k%count;
		temp.next = head;
		while (k>0){
			temp = temp.next;
			k--;
		}
		ListNode result = temp.next;
		temp.next = null;
		return result;
	}
	
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		ListNode listNode1 = rotateRight3(listNode,2);
	}
}
