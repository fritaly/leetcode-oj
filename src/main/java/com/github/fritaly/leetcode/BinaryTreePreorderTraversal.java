package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<Integer> traverse(TreeNode node, List<Integer> list) {
		if (node != null) {
			list.add(node.val);
			
			if (node.left != null) {
				traverse(node.left, list);
			}
			
			if (node.right != null) {
				traverse(node.right, list);
			}
		}
		
		return list;
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        return traverse(root, new ArrayList<Integer>());
    }
}