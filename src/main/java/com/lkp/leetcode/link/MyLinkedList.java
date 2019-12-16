package com.lkp.leetcode.link;

/**
 *@className MyLinkedList
 *@description 设计链表
 *@Auther 85291173@qq.com
 *@Date 2019/9/18 14:32
 *@Version
 */
 public class MyLinkedList {
	/**
	 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
	 
	 在链表类中实现这些功能：
	 
	 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
	 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
	 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
	 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
	 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
	 
	 示例：
	 MyLinkedList linkedList = new MyLinkedList();
	 linkedList.addAtHead(1);
	 linkedList.addAtTail(3);
	 linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
	 linkedList.get(1);            //返回2
	 linkedList.deleteAtIndex(1);  //现在链表是1-> 3
	 linkedList.get(1);            //返回3
	 *
	 */
	/** Initialize your data structure here. */
	private ListNode head = null;
	private int count = -1;
	public MyLinkedList() {
		head = new ListNode(-1);
	}
	
	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if(index > count|| index < 0 || count < 0){
			return -1;
		}
		
		ListNode temp = head;
		int i = 0 ;
		while (temp.next != null){
			if (i == index){
				break;
			}
			temp = temp.next;
			i++;
		}
		return temp.next.val;
	}
	
	/**
	 * Add a node of value val before the first element of the linked list.
	 * After the insertion, the new node will be the first node of the linked list.
	 * */
	public void addAtHead(int val) {
		ListNode temp = new ListNode(val);
		temp.next = head.next;
		head.next = temp;
		count++;
	}
	
	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode temp = head;
		while (temp.next != null){
			temp = temp.next;
		}
		temp.next = new ListNode(val);
		count++;
	}
	
	/** Add a node of value val before the index-th node in the linked list.
	 * If index equals to the length of linked list, the node will be appended to the end of linked list.
	 * If index is greater than the length, the node will not be inserted.
	 * 在链表中的第 index 个节点之前添加值为 val  的节点。
	 * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
	 * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
	 * */
	
	public void addAtIndex(int index, int val) {
		if ((count+1) < index){
			return;
		}else if(index <= 0){
			ListNode temp = new ListNode(val);
			head.next = temp;
		}else if((count+1) == index){
			ListNode temp = head;
			while (temp.next != null){
				temp = temp.next;
			}
			temp.next = new ListNode(val);
		}else {
			ListNode pre = head;
			ListNode temp = head.next;
			int i = 0;
			while (temp != null){
				if(i == index){
					break;
				}
				i++;
				temp = temp.next;
				pre =pre.next;
			}
			pre.next = new ListNode(val);
			pre.next.next = temp;
		}
		count++;
	}
	
	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(index > count || index < 0 || count < 0){
			return;
		}
		ListNode pre = head;
		ListNode temp = head.next;
		int i = 0 ;
		while (temp != null){
			if (i == index){
				break;
			}
			pre = pre.next;
			temp = temp.next;
			i++;
		}
		pre.next = temp.next;
		count--;
	}
	
	public static void main(String[] args) {
//		MyLinkedList linkedList = new MyLinkedList();
//		linkedList.addAtHead(1);
//		linkedList.addAtTail(3);
//		linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//		int i = linkedList.get(1);//返回2
//		System.out.println(i);
//		linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//		linkedList.get(1);            //返回3
//		["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
//		[[],[0],[1,2],[0],[1],[0,1],[0],[1]]
//		MyLinkedList linkedList = new MyLinkedList();
//		int i = linkedList.get(0);
//		System.out.println(i);
//		linkedList.addAtIndex(1,2);
//		i = linkedList.get(0);
//		System.out.println(i);
//		i = linkedList.get(1);
//		System.out.println(i);
//		linkedList.addAtIndex(0,1);
//		i = linkedList.get(0);
//		System.out.println(i);
//		i = linkedList.get(1);
//		System.out.println(i);
//["MyLinkedList","addAtHead","addAtIndex","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex"]
//[[],[0],[1,9],[1,5],[7],[1],[5,8],[5,2],[3,0],[1],[0],[6]]
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(0);
		linkedList.addAtIndex(1,9);
		linkedList.addAtIndex(1,5);
		linkedList.addAtTail(7);
		linkedList.addAtHead(1);
		linkedList.addAtIndex(5,8);
		linkedList.addAtIndex(5,2);
		linkedList.addAtIndex(3,0);
		linkedList.addAtTail(0);
		linkedList.addAtTail(6);
		
		
		
	}
}
