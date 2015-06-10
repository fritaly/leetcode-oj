package com.github.fritaly.leetcode;

public class UniqueBinarySearchTrees {

	public int numTrees(int n) {
		final int[] table = new int[n + 1];
		table[0] = 1;
		
		if (n >= 1) {
			// Only 1 way to arrange a 1-element tree
			table[1] = 1;
			
			if (n >= 2) {
				// Only 2 ways of arranging a 2-element tree
				table[2] = 2;
				
				for (int i = 3; i <= n; i++) {
					// Loop over each element and consider each one as the root of 
					// the tree (lower elements are part of the left sub-tree, greater 
					// elements are in the right sub-tree)
					for (int j = 1; j <= i; j++) {
						// How many numbers are in the left and right sub-trees ?
						final int left = j - 1;
						final int right = i - 1 - left;
						
						// The number of possible combinations for this root element is 
						// the product of number of combinations of each sub-tree
						table[i] += table[left] * table[right];
					}
				}
			}
		}
		
		return table[n];
	}
}