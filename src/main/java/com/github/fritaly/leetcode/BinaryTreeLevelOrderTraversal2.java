package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		final List<List<Integer>> result = new ArrayList<>();

		final LinkedList<TreeNode> queue = new LinkedList<>();

		final List<TreeNode> buffer = new ArrayList<>();

		if (root != null) {
			buffer.add(root);
		}

		while (!buffer.isEmpty()) {
			queue.addAll(buffer);
			buffer.clear();

			final List<Integer> list = new ArrayList<>();

			while (!queue.isEmpty()) {
				final TreeNode node = queue.removeFirst();

				list.add(node.val);

				if (node.left != null) {
					buffer.add(node.left);
				}
				if (node.right != null) {
					buffer.add(node.right);
				}
			}

			result.add(list);
		}

		Collections.reverse(result);

		return result;
	}
}