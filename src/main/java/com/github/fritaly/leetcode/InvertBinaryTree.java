package com.github.fritaly.leetcode;

public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			final TreeNode temp = root.right;
			
			root.right = invertTree(root.left);
			root.left = invertTree(temp);
		}
		
		return root;
	}
}