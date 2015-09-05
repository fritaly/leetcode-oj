package com.github.fritaly.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        final int n = nums.length + 1;
        final int total = (n * (n - 1)) / 2;
        
        int sum = 0;
        
        for (int i : nums) {
			sum += i;
		}
        
        return total - sum;
    }
}