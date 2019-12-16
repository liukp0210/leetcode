package com.lkp.leetcode.link.doublelink;



/**
 *@className MyLinkedList
 *@description 双链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 11:31
 *@Version
 */
public class MyLinkedList {
	DoublyListNode listNode = null;
	int size = 0 ;
	/** Initialize your data structure here. */
	public MyLinkedList() {
		listNode = new DoublyListNode(-1);
	}
	
	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if(this.size <= index){
			return -1;
		}
		int i = 0 ;
		DoublyListNode temp = listNode.next;
		while (temp != null){
			if(i == index){
				return  temp.val;
			}
			i++;
			temp = temp.next;
		}
		return -1;
	}
	
	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		addAtIndex(0,val);
		
	}
	
	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addAtIndex(size,val);
	}
	
	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		int i = 0;
		DoublyListNode pre = this.listNode;
		DoublyListNode curr = this.listNode.next;
		while (curr != null){
			if(i == index){
				break;
			}
			i++;
			pre = curr;
			curr = curr.next;
		}
		DoublyListNode temp = new DoublyListNode(val);
		temp.prev = pre ;
		temp.next = curr;
		if(curr != null){
			curr.prev = temp;
		}
		pre.next = temp;
		size++;
		
	}
	
	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		DoublyListNode pre = this.listNode;
		DoublyListNode curr = this.listNode.next;
		int i = 0 ;
		while (curr != null){
			if(i == index){
				pre.next = curr.next;
				curr.prev = pre;
				break;
			}
			i++;
			pre = curr;
			curr = curr.next;
		}
		
	}
	
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1,2);
		int i = linkedList.get(1);
		System.out.println(i);
		linkedList.deleteAtIndex(1);
		int i1 = linkedList.get(1);
		System.out.println(i1);
	}

}

class DoublyListNode {
	int val;
	DoublyListNode next, prev;
	DoublyListNode(int x) {val = x;}
}
