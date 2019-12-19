package com.lkp.leetcode.hash;

/**
 *@className MyHashMap
 *@description 706. 设计哈希映射
 *@Auther 85291173@qq.com
 *@Date 2019/12/19 13:43
 *@Version
 */
public class MyHashMap {
	class Node<k,v> {
		k key;
		v value;
		Node<k,v> next;
		public Node(k key,v value){
			this.key = key;
			this.value = value;
		}
	}
	private int length = 1000;
	private Node[] nodes = new Node[length];
	/** Initialize your data structure here. */
	public MyHashMap() {
	
	}
	
	/** value will always be non-negative. */
	public void put(int key, int value) {
		int i = key/length;
		Node<Integer,Integer> node = nodes[i];
		if(node == null){
			nodes[i] = new Node(key,value);
		}else{
			if(node.key == key){
				node.value = value;
				return;
			}
			Node<Integer,Integer> prev = node;
			Node<Integer,Integer> temp = node.next;
			while (temp != null){
				if(temp.key == key){
					temp.value = value;
					return;
				}
				prev = temp;
				temp = temp.next;
			}
			prev.next = new Node<>(key,value);
		}
	}
	
	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int i = key/length;
		Node<Integer,Integer> node = nodes[i];
		if(node == null){
			return -1;
		}
		Node<Integer,Integer> temp = node;
		while (temp != null){
			if(temp.key == key){
				return temp.value;
			}
			temp = temp.next;
		}
		return -1;
	}
	
	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int i = key/length;
		Node<Integer,Integer> node = nodes[i];
		if(node == null){
			return;
		}else{
			if(node.key == key){
				nodes[i] = node.next;
				return;
			}
			Node<Integer,Integer> prev = node;
			Node<Integer,Integer> temp = node.next;
			while (temp != null){
				if(temp.key == key){
					prev.next = temp.next;
					return;
				}
				prev = temp;
				temp = temp.next;
			}
		}
	}
}
