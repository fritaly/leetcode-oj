package com.github.fritaly.leetcode;

public class MinimumDepthOfBinaryTree {

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

		if (node.left == null) {
			if (node.right == null) {
				return 1;
			}

			return 1 + getDepth(node.right);
		} else {
			if (node.right == null) {
				return 1 + getDepth(node.left);
			}

			return 1 + Math.min(getDepth(node.left), getDepth(node.right));
		}
	}

    public int minDepth(TreeNode root) {
		return getDepth(root);
	}
}