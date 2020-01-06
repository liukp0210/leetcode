package com.lkp.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@className FindDuplicateSubtrees
 *@description 652. 寻找重复的子树
 *@Auther 85291173@qq.com
 *@Date 2020/1/6 9:42
 *@Version
 */
public class FindDuplicateSubtrees {
	Map<String,Integer> map = null;
	List<TreeNode> list = null;
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		map = new HashMap<>();
		list = new ArrayList<>();
		collection(root);
		return list;
	}

	public String collection(TreeNode node){
		if (node == null){
			return  "#";
		}
		String str = node.val + collection(node.left)  +  collection(node.right);
		map.put(str,map.getOrDefault(str,0) + 1);
		if(map.get(str) == 2){
			list.add(node);
		}
		return str;
	}
//    int t;
//	Map<String, Integer> trees;
//	Map<Integer, Integer> count;
//	List<TreeNode> ans;
//
//	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//		t = 1;
//		trees = new HashMap();
//		count = new HashMap();
//		ans = new ArrayList();
//		lookup(root);
//		return ans;
//	}
//
//	public int lookup(TreeNode node) {
//		if (node == null) return 0;
//		String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
//		int uid = trees.computeIfAbsent(serial, x-> t++);
//		count.put(uid, count.getOrDefault(uid, 0) + 1);
//		if (count.get(uid) == 2)
//			ans.add(node);
//		return uid;
//	}
	
	
	
	public static void main(String[] args) {
//		FindDuplicateSubtrees a = new FindDuplicateSubtrees();
//		a.findDuplicateSubtrees()
		
		Map<String,Integer> trees = new HashMap<>();
		int uid = trees.computeIfAbsent("a", x-> 2);
		System.out.println(uid);
	}
	
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }