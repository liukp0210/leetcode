package com.lkp.leetcode.link;

/**
 *@className IsPalindrome
 *@description 回文链表
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 10:23
 *@Version
 */
public class IsPalindrome {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(2);
		listNode.next.next.next = new ListNode(1);
		isPalindrome(listNode);
	}
	/**
	 * @param head
	 * @return
	 * @Description 反转前半部分链表然后和后半部分链表进行对比
	 * 判断链表长度为奇数还是偶数
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode temp = head;
		ListNode fast = head;
		ListNode pre = null;
		while (fast != null && fast.next != null) {
			//fast = fast.next.next; 如果放到后面 head.next对应的指针就会发生变化
			fast = fast.next.next;
			ListNode next = temp.next;
			temp.next = pre;
			pre = temp;
			temp = next;
		}
		if(fast != null){
			temp = temp.next;
		}
		while (pre != null && temp != null){
			if(pre.val != temp.val){
				return  false;
			}
			pre = pre.next;
			temp = temp.next;
		}
		return true;
	}
	
	public static boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		ListNode pre = head, prepre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			pre.next = prepre;
			prepre = pre;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (pre != null && slow != null) {
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}
		return true;
	}
}
