package com.lkp.leetcode.link;

/**
 *@className IntersectLinked
 *@description 相交链表
 *@Auther 85291173@qq.com
 *@Date 2019/9/18 16:23
 *@Version
 */
public class IntersectLinked {
	
	/**
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 
	 For example, the following two linked lists:
	 
	 
	 begin to intersect at node c1.
	 
	  
	 
	 Example 1:
	 
	 
	 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
	 Output: Reference of the node with value = 8
	 Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
	  
	 
	 Example 2:
	 
	 
	 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	 Output: Reference of the node with value = 2
	 Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
	  
	 
	 Example 3:
	 
	 
	 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	 Output: null
	 Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
	 Explanation: The two lists do not intersect, so return null.
	  
	 
	 Notes:
	 
	 If the two linked lists have no intersection at all, return null.
	 The linked lists must retain their original structure after the function returns.
	 You may assume there are no cycles anywhere in the entire linked structure.
	 Your code should preferably run in O(n) time and use only O(1) memory.
	 
	 分析：将两个链表反转，
	 使用双指针 然后比较每个节点的值进行比较，如果如果值相等，则将值传入赋值到一个新的链表中
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode preA = new ListNode(-1);
		ListNode tempA = headA;
		while (tempA != null){
			
			ListNode temp = new ListNode(tempA.val);
			temp.next = preA.next;
			preA.next = temp;
			tempA = tempA.next;
		}
		
		ListNode preB = new ListNode(-1);
		ListNode tempB = headB;
		while (tempB != null){
			ListNode temp = new ListNode(tempB.val);
			temp.next = preB.next;
			preB.next = temp;
			tempB = tempB.next;
		}
		ListNode resNode = new ListNode(-1);
		preA = preA.next;
		preB = preB.next;
		while (preA != null && preB != null){
			if(preA.val == preB.val){
				ListNode temp = new ListNode(preA.val);
				temp.next = resNode.next;
				resNode.next = temp;
				preA = preA.next;
				preB = preB.next;
			}else {
				break;
			}
		}
		return resNode.next;
	}
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		/**
		 定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
		 两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
		 **/
		if(headA == null || headB == null) return null;
		ListNode pA = headA, pB = headB;
		// 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
		while(pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
	
	public static void main(String[] args) {
		/**
		 * [4,1,8,4,5]
		 * [5,0,1,8,4,5]
		 *
		 */
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = new ListNode(8);
		headB.next.next.next.next = new ListNode(4);
		headB.next.next.next.next.next = new ListNode(5);
		IntersectLinked linked = new IntersectLinked();
		ListNode intersectionNode = linked.getIntersectionNode1(headA, headB);
	}
}
