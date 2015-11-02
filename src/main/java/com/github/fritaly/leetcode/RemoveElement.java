package com.github.fritaly.leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
    	int readIndex = 0, writeIndex = 0, deleted = 0;
    	
    	while (readIndex < nums.length) {
    		if (nums[readIndex] != val) {
    			nums[writeIndex++] = nums[readIndex++];
    		} else {
    			readIndex++;
    			deleted++;
    		}
    	}
    	
    	return nums.length - deleted;
    }
}