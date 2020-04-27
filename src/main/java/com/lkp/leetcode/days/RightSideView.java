package com.lkp.leetcode.days;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@className RightSideView
 *@description 199. 二叉树的右视图
 *@Auther 85291173@qq.com
 *@Date 2020/4/22 11:39
 *@Version
 */
public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer>  map = new HashMap<>();
		findRight(root,map,0);
		for (int i = 0; i < map.size() ; i++) {
			list.add(map.get(i));
		}
		return list;
	}
	
	private void findRight(TreeNode root,Map<Integer,Integer> map, int i) {
		if(null == root){
			return;
		}
		if(!map.containsKey(i)){
			map.put(i,root.val);
		}
		findRight(root.right,map,i+1);
		findRight(root.left,map,i+1);
	}
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
