package com.github.fritaly.leetcode;

public class ConvertSortedArrayToBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    private TreeNode sortedArrayToBST(int[] num, int start, int end) {
    	if (start == end) {
    		return new TreeNode(num[start]);
    	}
    	
    	int mid = (start + end) / 2;
    	
		final TreeNode node = new TreeNode(num[mid]);
		
		if (mid > start) {
			node.left = sortedArrayToBST(num, start, mid - 1);
		}
		if (mid < end) {
			node.right = sortedArrayToBST(num, mid + 1, end);
		}
		
		return node;
    }
	
    public TreeNode sortedArrayToBST(int[] num) {
        if ((num == null) || (num.length == 0)) {
        	return null;
        }
        
        return sortedArrayToBST(num, 0, num.length - 1);
    }
}