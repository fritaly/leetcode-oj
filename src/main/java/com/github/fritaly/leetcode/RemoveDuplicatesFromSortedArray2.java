package com.github.fritaly.leetcode;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
		Integer previous = null, previousPrevious = null;
		int duplicates = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if ((previous != null) && (previousPrevious != null) && (previous == nums[i]) && (previous == previousPrevious)) {
				duplicates++;
			}
			
			nums[i - duplicates] = nums[i];
			
			previousPrevious = previous;
			previous = nums[i];
		}
		
		return nums.length - duplicates;
    }
}