package com.github.fritaly.leetcode;

import java.util.Arrays;

public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {
    	final int index = Arrays.binarySearch(nums, target);
    	
    	if (index < 0) {
    		return new int[] { -1, -1 };
    	}
    	
    	int startIndex = index, endIndex = index;
    	
    	while ((startIndex > 0) && (nums[startIndex - 1] == target)) {
    		startIndex--;
    	}
    	while ((endIndex < nums.length - 1) && (nums[endIndex + 1] == target)) {
    		endIndex++;
    	}
    	
    	return new int[] { startIndex, endIndex };
    }
}