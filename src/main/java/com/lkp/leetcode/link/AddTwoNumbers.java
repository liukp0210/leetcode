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
}
