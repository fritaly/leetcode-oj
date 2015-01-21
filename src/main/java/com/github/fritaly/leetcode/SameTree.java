package com.github.fritaly.leetcode;

public class SameTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		@SuppressWarnings("unused")
		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null) && (q == null)) {
			return true;
		}
		if ((p == null) || (q == null)) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		if (p.left != null) {
			if ((q.left == null) || !isSameTree(p.left, q.left)) {
				return false;
			}
		} else {
			if (q.left != null) {
				return false;
			}
		}

		if (p.right != null) {
			if ((q.right == null) || !isSameTree(p.right, q.right)) {
				return false;
			}
		} else {
			if (q.right != null) {
				return false;
			}
		}

		return true;
	}
}