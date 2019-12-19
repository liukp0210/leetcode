package com.lkp.leetcode.hash;

/**
 *@className MyHashSet
 *@description 705. 设计哈希集合
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 9:11
 *@Version
 */
public class MyHashSet {
	
	class Node<T> {
		private T val;
		Node<T> next;
		Node<T> prev;
		
		public Node(T val) {
			this.val = val;
		}
	}
	
	private int length = 100;
	Node[] nodes = new Node[length];
	/** Initialize your data structure here. */
	public MyHashSet() {
	
	}
	
	public void add(int key) {
		int i = key % length;
		Node<Integer> node = nodes[i];
		if(node == null){
			Node<Integer> node1 = new Node<>(key);
			nodes[i] = node1;
			return;
		}else{
			if(node.val == key){
				return;
			}
			Node<Integer> temp = node;
			while (temp.next != null){
				if(temp.val == key){
					return;
				}
				temp = temp.next;
			}
			Node<Integer> integerNode = new Node<>(key);
			temp.next = integerNode;
			integerNode.prev = temp;
		}
		
	}
	
	public void remove(int key) {
		int i = key % length;
		Node<Integer> node = nodes[i];
		if(node != null && node.val == key){
			Node<Integer> next = node.next;
			if(next != null){
				next.prev = null;
			}
			nodes[i] = next;
			return;
		}
		if(node == null){
			return;
		}
		Node<Integer> temp = node.next;
		while (temp != null){
			if (temp.val == key){
				Node<Integer> next = temp.next;
				Node<Integer> prev = temp.prev;
				if(prev != null){
					prev.next = next;
				}
				if(next != null){
					next.prev = prev;
				}
				break;
			}
			temp = temp.next;
		}
		
	}
	
	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int i = key % length;
		Node<Integer> node = nodes[i];
		Node<Integer> temp = node;
		while (temp != null){
			if(temp.val == key){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(9);
		myHashSet.remove(19);
		myHashSet.add(14);
		myHashSet.remove(19);
		myHashSet.remove(9);
		myHashSet.add(0);
		myHashSet.add(3);
		myHashSet.add(4);
		myHashSet.add(0);
		myHashSet.remove(9);
		
		
		
		
	}
}
