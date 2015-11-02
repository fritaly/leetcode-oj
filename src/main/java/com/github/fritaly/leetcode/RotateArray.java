package com.github.fritaly.leetcode;

public class RotateArray {

    public void rotate(int[] nums, int k) {
    	final int n = nums.length;
    	
    	k = k % n;
    	
    	int readIndex = (n - k) % n;
    	
    	final int[] array = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		array[i] = nums[readIndex];
    		
    		readIndex = (readIndex + 1) % n;
		}
    	
    	System.arraycopy(array, 0, nums, 0, n);
    }
}