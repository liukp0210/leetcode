package com.lkp.leetcode.link;

import java.util.HashMap;

/**
 *@className CopyRandomList
 *@description 138. 复制带随机指针的链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/17 9:18
 *@Version
 */
 public class CopyRandomList {
	class Node {
		public int val;
		public Node next;
		public Node random;
		
		public Node(int val) {}
		
		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	}
	HashMap<Node,Node> visitedHash = new HashMap<>();
	public Node copyRandomList(Node head) {
		if (head == null){
			return null;
		}
		if(this.visitedHash.containsKey(head)){
			return this.visitedHash.get(head);
		}
		Node node = new Node(head.val,null,null);
		this.visitedHash.put(head,node);
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);
		return node;
	}
	public Node copyRandomList2(Node head) {
		
		if (head == null) {
			return null;
		}
		
		// Creating a new weaved list of original and copied nodes.
		Node ptr = head;
		while (ptr != null) {
			
			Node newNode = new Node(ptr.val);
			//  A->B->C => A->A'->B->B'->C->C'
			newNode.next = ptr.next;
			ptr.next = newNode;
			ptr = newNode.next;
		}
		
		ptr = head;
		
		//random point
		while (ptr != null) {
			ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
			ptr = ptr.next.next;
		}
		
		// A->A'->B->B'->C->C' => A->B->C and A'->B'->C'
		Node ptr_old_list = head; // A->B->C
		Node ptr_new_list = head.next; // A'->B'->C'
		Node head_old = head.next;
		while (ptr_old_list != null) {
			ptr_old_list.next = ptr_old_list.next.next;
			ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
			ptr_old_list = ptr_old_list.next;
			ptr_new_list = ptr_new_list.next;
		}
		return head_old;
	}
	
}
