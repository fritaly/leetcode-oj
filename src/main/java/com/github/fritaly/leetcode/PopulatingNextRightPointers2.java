package com.github.fritaly.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class PopulatingNextRightPointers2 {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	private void traverse(TreeLinkNode node, Map<Integer, TreeLinkNode> map, int depth) {
		if (node != null) {
			if (map.containsKey(depth)) {
				map.get(depth).next = node;
			}
			
			map.put(depth, node);
			
			if (node.left != null) {
				traverse(node.left, map, depth + 1);
			}
			if (node.right != null) {
				traverse(node.right, map, depth + 1);
			}
		}
	}

	public void connect(TreeLinkNode root) {
		traverse(root, new TreeMap<Integer, TreeLinkNode>(), 0);
	}
}