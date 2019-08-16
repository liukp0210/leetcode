package com.lkp.leetcode.recursion;

import static javafx.scene.input.KeyCode.L;

/**
 *@className Linked
 *@description 链表
 *@Auther 85291173@qq.com
 *@Date 2019/7/22 9:43
 *@Version
 */
public class Linked {
	
//	public static void main(String[] args) {
//		ListNode listNode1 = new ListNode(1);
//		listNode1.next = new ListNode(2);
//		listNode1.next.next = new ListNode(4);
//		ListNode listNode2 = new ListNode(1);
//		listNode2.next = new ListNode(3);
//		listNode2.next.next = new ListNode(4);
//		ListNode prehead = mergeTwoLists3(listNode1, listNode2);
//		ListNode prehead = new ListNode(-1);
//		ListNode listNode = prehead;
//		while (listNode1 != null && listNode2 != null){
//			if(listNode1.val <= listNode2.val){
//				listNode.next = listNode1;
//				listNode1 = listNode1.next;
//			}else{
//				listNode.next = listNode2;
//				listNode2 = listNode2.next;
//			}
//			listNode = listNode.next;
//		}
//		if(listNode1 == null){
//			listNode.next = listNode2;
//		}else{
//			listNode.next = listNode1;
//		}
//		while (prehead != null){
//			System.out.println(prehead.val);
//			prehead = prehead.next;
//		}
//	}
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// maintain an unchanging reference to node ahead of the return node.
		ListNode prehead = new ListNode(-1);
		
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		
		// exactly one of l1 and l2 can be non-null at this point, so connect
		// the non-null list to the end of the merged list.
		prev.next = l1 == null ? l2 : l1;
		
		return prehead.next;
	}
	
	/**
	 *
	 * @param t1  1 2 4
	 * @param t2  1 3 4
	 * 1.  124 34
	 * 2. 24 34
	 * 3. 4 34
	 * 4. 4 4
	 * 5. 4 null
	 * @return
	 */
	public static ListNode mergeTowLists(ListNode t1,ListNode t2){
		/**
		 * 终止条件 t1 或者 t2为null
		 */
		if(t1 == null){
			return t2;
		}else if (t2 == null){
			return t1;
		}else if(t1.val < t2.val){
			t1.next = mergeTowLists(t1.next,t2);
			return t1;
		}else{
			t2.next = mergeTowLists(t1,t2.next);
			return t2;
		}
		
	}
	public static ListNode mergeTwoLists3(ListNode t1,ListNode t2){
		 ListNode k = new ListNode(-1);
		 ListNode m = k;
		 while (t1 != null && t2 != null){
		 	if(t1.val < t2.val){
		 		m.next = t1;
		 		t1 = t1.next;
			}else{
				m.next = t2;
				t2 = t2.next;
			}
			 m = m.next;
		 }
		 if(t1 == null){
			 m.next = t2;
		 }else{
		 	m.next = t1;
		 }
		 return k.next;
	}
	
	public static void main(String[] args) {
		int i = 0;
		
		switch (i) {
			case 0:
				System.out.println("zero");
			case 1:
				System.out.println("one");
			case 2:
				System.out.println("two");
				break;
			case 3:
				System.out.println("three");
		}

	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}