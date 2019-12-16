package com.lkp.leetcode.link;

/**
 *@className Flatten
 *@description 430. 扁平化多级双向链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 15:49
 *@Version
 */
public class Flatten {
	public Node flatten(Node head) {
//		Node pre = head;
		Node curr = head;
		while (curr != null){
			if(curr.child != null){
				Node next = curr.next;
				Node flatten = flatten(curr.child);
				curr.child = null;
				flatten.prev = curr;
				curr.next = flatten;
				while (flatten.next != null){
					flatten = flatten.next;
				}
				flatten.next = next;
				if(next != null) {
					next.prev = flatten;
				}
				curr = next;
			}else{
				curr = curr.next;
			}
		}
		return head;
	}
}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
}