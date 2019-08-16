package com.lkp.leetcode.stack;

import java.util.*;
import java.util.function.Predicate;

/**
 *@className StackUsingQueues
 *@description Implement Stack using queues
 *@Auther 85291173@qq.com
 *@Date 2019/8/6 13:57
 *@Version
 */
 public class MyStack {
	
	/**
	 * Implement the following operations of a stack using queues.
	 *  push(x) -- Push element x into stack.
	 *  pop() --Removes the element on the top of the stack.
	 *  top() --Get the top element .
	 *  empty() --Return whether the stack is empty.
	 *
	 *	Example:
	 
	 MyStack stack = new MyStack();
	 
	 stack.push(1);
	 stack.push(2);  
	 stack.top();   // returns 2
	 stack.pop();   // returns 2
	 stack.empty(); // returns false
	 Notes:
	 *  You must use only standard operations of a queue -- which means only push to back,peek/pop from front,size,and is empty operations are valid
	 *  Depending on your language,queue may not be supported natively. You may simulate a queue by using a list or deque(double-ended queue),
	 *  as long as you use only standard operations of a queue.
	 *  You may assume that all operations are valid (for example,no pop or top operations will be called on an empty stack).
	 * 
	 */
	/** Initialize your data structure here. */
	Queue<Integer> queue = null;
	public MyStack() {
		queue = new ArrayDeque<>();
	}
	
	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
	}
	
	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		Iterator<Integer> iterator = queue.iterator();
		int size = queue.size();
		int i= 0;
		while (iterator.hasNext()){
			i++;
			Integer next = iterator.next();
			if(i == size){
				iterator.remove();
				return next;
			}
		}
		throw  new RuntimeException("系统异常");
	}
	
	/** Get the top element. */
	public int top() {
		Iterator<Integer> iterator = queue.iterator();
		int size = queue.size();
		int i= 0;
		while (iterator.hasNext()){
			i++;
			Integer next = iterator.next();
			if(i == size){
				return next;
			}
		}
		throw  new RuntimeException("系统异常");
	}
	
	/** Returns whether the stack is empty. */
	public boolean empty() {
		if(queue.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		// returns 2
		System.out.println(stack.top());
		// returns 2
		System.out.println(stack.pop());
		// returns false
		System.out.println(stack.empty());
	}
}
