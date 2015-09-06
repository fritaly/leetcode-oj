package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private static void traverse(List<String> result, String path, TreeNode node) {
		if (node == null) {
			return;
		}
		
		final String newPath = (path == null) ? Integer.toString(node.val) : String.format("%s->%d", path, node.val);
			
		if (node.left != null) {
			traverse(result, newPath, node.left);
		}
		if (node.right != null) {
			traverse(result, newPath, node.right);
		}
		if ((node.left == null) && (node.right == null)) {
			result.add(newPath);
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		final List<String> result = new ArrayList<String>();
		
		traverse(result, null, root);
		
		return result;
	}
}