package com.lkp.leetcode.link;

/**
 *@className AddTwoNumbers
 *@description 2. 两数相加
 *@Auther 85291173@qq.com
 *@Date 2019/12/16 15:09
 *@Version
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean flag = false;
		ListNode result = new ListNode(-1);
		ListNode pre = result;
		while (l1 != null || l2 != null){
			int i = (l1 == null?0:l1.val) + (l2 == null?0:l2.val);
			if(flag) i++;
			if(i >= 10){
				flag = true;
			}else{
				flag = false;
			}
			ListNode temp = new ListNode(i%10);
			pre.next = temp;
			pre = pre.next;
			l1 = l1 == null?null:l1.next;
			l2 = l2 == null?null:l2.next;
		}
		if(flag)pre.next = new ListNode(1);
		return result.next;
	}
	
	/**
	 * TODO 会出现溢出问题 所以不能转成数字
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		//第一步将两个链表的值取出来，然后相加再将值放入到链表中
		long num1 = 0 ;
		while (l1 != null ){
			num1 = num1*10 + l1.val;
			l1 = l1.next;
		}
		long num2 = 0 ;
		while (l2 != null ){
			num2 = num2*10 + l2.val;
			l2 = l2.next;
		}
		System.out.println(num1);
		System.out.println(num2);
		long i = num1 + num2;
		System.out.println(i);
		ListNode result = new ListNode(-1);
		while (i>0){
			long i1 = i % 10;
			ListNode next = result.next;
			result.next = new ListNode((int) i1);
			result.next.next = next;
			i /= 10;
		}
		return result.next == null?new  ListNode(0):result.next;
	}
	
	/**
	 * TODO 反转链表，将链表从低位到高位相加之后再将链表反转
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		ListNode pro1 = null;
		ListNode temp = l1;
		while (temp != null){
			ListNode next = temp.next;
			temp.next = pro1;
			pro1 = temp;
			temp = next;
		}
		ListNode pro2 = null;
		ListNode temp2 = l2;
		while (temp2 != null){
			ListNode next = temp2.next;
			temp2.next = pro2;
			pro2 = temp2;
			temp2 = next;
		}
		ListNode result = new ListNode(-1);
		ListNode tempResult = result ;
		int flag = 0;
		while (pro1 != null ||  pro2 != null){
			int i = (pro1 == null ? 0 : pro1.val) + (pro2 == null ? 0 : pro2.val)+flag;
			tempResult.next = new ListNode(i%10) ;
			flag = 0 ;
			if(i>=10){
				flag  = 1;
			}
			if(pro1 != null){
				pro1 = pro1.next;
			}
			if(pro2 != null){
				pro2 = pro2.next;
			}
			tempResult = tempResult.next;
		}
		if(flag == 1){
			tempResult.next = new ListNode(1) ;
		}
		ListNode pro3 = null;
		ListNode tempResult3 = result.next ;
		while (tempResult3 != null){
			ListNode next = tempResult3.next;
			tempResult3.next = pro3;
			pro3 = tempResult3;
			tempResult3 = next;
		}
		return pro3;
	}
	
	public static void main(String[] args) {
		ListNode listNode = new ListNode(5);
//		listNode.next = new ListNode(2);
//		listNode.next.next = new ListNode(3);
//		listNode.next.next.next = new ListNode(4);
//		listNode.next.next.next.next = new ListNode(5);
		ListNode listNode2 = new ListNode(5);
//		listNode2.next = new ListNode(2);
//		listNode2.next.next = new ListNode(3);
//		listNode2.next.next.next = new ListNode(4);
//		listNode2.next.next.next.next = new ListNode(5);
		ListNode listNode1 = addTwoNumbers3(listNode, listNode2);
		System.out.println(listNode1);
	}
	
}
