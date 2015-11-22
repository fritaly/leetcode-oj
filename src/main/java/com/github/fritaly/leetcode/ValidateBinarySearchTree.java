package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;


public class ValidateBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private List<Integer> traverse(TreeNode node, List<Integer> values) {
		if (node.left != null) {
			traverse(node.left, values);
		}
		
		values.add(node.val);
		
		if (node.right != null) {
			traverse(node.right, values);
		}
		
		return values;
	}
	
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        
        final List<Integer> values = traverse(root, new ArrayList<Integer>());
		
		Integer previous = null;
		
		for (Integer value : values) {
			if (previous != null) {
				if (previous >= value) {
					return false;
				}
			}
			
			previous = value;
		}
		
		return true;
    }
}