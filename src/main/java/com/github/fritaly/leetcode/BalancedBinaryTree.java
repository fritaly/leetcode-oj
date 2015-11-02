package com.github.fritaly.leetcode;

public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private int depth(TreeNode node) {
		int depth = 0;
		
		if (node != null) {
			depth++;
			
			if (node.left != null) {
				depth = Math.max(depth, 1 + depth(node.left));
			}
			if (node.right != null) {
				depth = Math.max(depth, 1 + depth(node.right));
			}
		}
		
		return depth;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
			return false;
		}
		
		if (!isBalanced(root.left) || !isBalanced(root.right)) {
			return false;
		}
		
		return true;
	}
}