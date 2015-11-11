package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeRightSideView {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private void recurse(TreeNode node, int depth, Map<Integer, Integer> values) {
		if (node != null) {
			values.put(depth, node.val);
			
			recurse(node.left, depth + 1, values);
			recurse(node.right, depth + 1, values);
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		final Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		recurse(root, 0, map);
		
		return new ArrayList<Integer>(map.values());
	}
}