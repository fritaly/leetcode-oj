package com.github.fritaly.leetcode;

public class SymmetricTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if ((node1 == null) && (node2 == null)) {
			return true;
		}
		if ((node1 == null) || (node2 == null)) {
			return false;
		}

		return (node1.val == node2.val) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
	}

	public boolean isSymmetric(TreeNode root) {
		return (root == null) || isSymmetric(root.left, root.right);
	}
}