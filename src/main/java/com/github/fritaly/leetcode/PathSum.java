package com.github.fritaly.leetcode;

public class PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left != null) {
			if (hasPathSum(root.left, sum - root.val)) {
				return true;
			}
		}
		if (root.right != null) {
			if (hasPathSum(root.right, sum - root.val)) {
				return true;
			}
		}

		return (root.val == sum) && (root.left == null) && (root.right == null);
	}
}