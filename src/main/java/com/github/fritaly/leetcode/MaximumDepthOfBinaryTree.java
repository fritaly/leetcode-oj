package com.github.fritaly.leetcode;

public class MaximumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int depth = 1;

		if (node.left != null) {
			depth = Math.max(depth, 1 + getDepth(node.left));
		}
		if (node.right != null) {
			depth = Math.max(depth, 1 + getDepth(node.right));
		}

		return depth;
	}

	public int maxDepth(TreeNode root) {
		return getDepth(root);
	}
}