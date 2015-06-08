package com.github.fritaly.leetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		Integer previous = null;
		int duplicates = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if ((previous != null) && (previous == nums[i])) {
				duplicates++;
			}
			
			nums[i - duplicates] = nums[i];
			
			previous = nums[i];
		}
		
		return nums.length - duplicates;
	}
}