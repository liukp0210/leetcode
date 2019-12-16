package com.lkp.leetcode.link;

/**
 *@className MergeTwoLists
 *@description 21. 合并两个有序链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 14:55
 *@Version
 */
public class MergeTwoLists {
	/**
	 * 1 2 4
	 * 1 3 4
	 *
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if (l2 == null){
			return l1;
		}
		if(l1.val < l2.val){
			ListNode listNode = new ListNode(l1.val);
			listNode.next = mergeTwoLists(l1.next, l2);
			return listNode;
		}else{
			ListNode listNode = new ListNode(l2.val);
			listNode.next = mergeTwoLists(l1, l2.next);
			return listNode;
		}
		
	}
}
