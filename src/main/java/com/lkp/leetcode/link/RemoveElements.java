package com.lkp.leetcode.link;

import java.util.List;

/**
 *@className RemoveElements
 *@description 移除链表元素
 *@Auther 85291173@qq.com
 *@Date 2019/9/17 9:55
 *@Version
 */
public class RemoveElements {
	
	/**
	 *
	 * 删除链表中等于给定值 val 的所有节点。
	 
	 示例:
	 输入: 1->2->6->3->4->5->6, val = 6
	 输出: 1->2->3->4->5
	 *[1,1]
	 * 1
	 *
	 *  双指针 pre 表示当前节点的上一个节点 初始化为空
	 *  temp 为当前节点
	 *  如果 temp.val = val 则 pre.next = temp.next temp = temp.next
	 *  else  pre = pre.next (如果pre==null则pre==temp) temp= temp.next
	 * @param head
	 * @param val
	 * @return
	 */
	
	public ListNode removeElements2(ListNode head, int val) {
		if(head == null){
			return head;
		}
		ListNode pre = null;
		ListNode temp = head;
		for (;;){
			if(temp.val == val){
				if(pre == null){
					pre = temp;
				}
				temp = temp.next;
			}else{
				pre = temp.next;
				temp = temp.next;
			}
			
		}
	}
	public ListNode removeElements(ListNode head, int val) {
		if(head == null){
			return head;
		}
		ListNode listNode = new ListNode(-1);
		listNode.next = head;
		ListNode temp = listNode;
		ListNode temp2 = temp.next;
		for (;;){
			if (temp2.val == val) {
				temp.next = temp2.next;
				temp2 = temp2.next;
			}else{
				temp2 = temp2.next;
				temp = temp.next;
			}
			if(temp2 == null){
				break;
			}
		}
		return listNode.next;
	}
	
	/**
	 * TODO 评论中最简单明了的算法 把我的代码精简一下也是这样
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements3(ListNode head, int val) {
		ListNode listNode = new ListNode(-1);
		listNode.next = head;
		ListNode temp = listNode;
		while (temp.next != null){
			if (temp.next.val == val){
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}
		return listNode.next;
	}
}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode ( int x) {
		this.val = x ;
	}
}