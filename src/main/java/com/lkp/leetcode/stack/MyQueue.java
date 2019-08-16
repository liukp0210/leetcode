package com.lkp.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 *@className QueueUsingStacks
 *@description Implement Queue using Stacks
 *@Auther 85291173@qq.com
 *@Date 2019/8/16 9:55
 *@Version
 */
 public class MyQueue {
	/**
	 * MyQueue queue = new MyQueue();
	 *
	 * queue.push(1)
	 * queue.push(2);
	 * queue.peek();  return 1;
	 * queue.pop() ;  return 1;
	 * queuq.empty();  return false;
	 *
	 * Notes:
	 * 	You msut only standard operations of a stack -- which means only push to top ,
	 * 	peek /pop from top,size and is empty operations are valid.
	 *
	 * 	Depending on your language,stack may not be supported natively.You may simulate a stack by
	 * 	using a list or deque (double-ended queue),as long as you
	 * 	use only standard operations of a stack.
	 *
	 * 	You may assume that all operations are valid (for example , not pop or peek operations will be called on an empty queue).
	 */
	private Stack<Integer> input = null;
	private Stack<Integer> output = null;
	/** Initialize your data structure here. */
	public MyQueue() {
		input = new Stack<>();
		output = new Stack<>();
		
	}
	
	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}
	
	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(output.size() == 0){
			while (input.size() > 0){
				output.push(input.pop());
			}
		}
		return output.pop();
	}
	
	/** Get the front element. */
	public int peek() {
		if(output.size() != 0 ){
			return output.peek();
		}else{
			while (input.size() > 0) {
				output.push(input.pop());
			}
			return output.peek();
		}
	}
	
	/** Returns whether the queue is empty. */
	public boolean empty() {
		return output.isEmpty()&& input.isEmpty() ;
	}
	
	/**
	 * queue队列 先进先出
	 * stack栈   先进后出
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		int peek = myQueue.peek();
		System.out.println(peek);
		int pop = myQueue.pop();
		System.out.println(pop);
		boolean empty = myQueue.empty();
		System.out.println(empty);
	}
}
