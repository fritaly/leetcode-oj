package com.github.fritaly.leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
    	if (nums.length == 0) {
    		return 0;
    	} else if (nums.length == 1) {
    		return nums[0];
    	} else if (nums.length == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	
        final int[] table = new int[nums.length + 1];
        table[0] = 0;
        table[1] = nums[0];
        table[2] = nums[1];
        
        for (int n = 3; n <= nums.length; n++) {
			int max1 = nums[n - 1] + table[n - 2];
			int max2 = table[n - 1];
			int max3 = nums[n - 1] + table[n - 3];
			
			table[n] = Math.max(Math.max(max1, max2), max3);
		}
        
        return table[nums.length];
    }
}