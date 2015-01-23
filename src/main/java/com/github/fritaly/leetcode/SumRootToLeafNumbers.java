package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static void sumNumbers(TreeNode node, int prefix, List<Integer> result) {
		if (node == null) {
			return;
		} else if ((node.left == null) && (node.right == null)) {
			result.add(prefix * 10 + node.val);
		} else {
			if (node.left != null) {
				sumNumbers(node.left, prefix * 10 + node.val, result);
			}
			if (node.right != null) {
				sumNumbers(node.right, prefix * 10 + node.val, result);
			}
		}
	}

	public int sumNumbers(TreeNode root) {
		final List<Integer> numbers = new ArrayList<>();

		sumNumbers(root, 0, numbers);

		int sum = 0;

		for (Integer number : numbers) {
			sum += number;
		}

		return sum;
	}
}