package com.github.fritaly.leetcode;

public class RangeSumQuery {

	private final int[] nums;
	
    public RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
    	int sum = 0;
    	
    	for (int k = i; k <= j; k++) {
			sum += nums[k];
		}
    	
    	return sum;
    }
}