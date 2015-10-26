package com.github.fritaly.leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0) {
			return new int[0];
		}
		
    	final LinkedList<Integer> window = new LinkedList<Integer>();
    	
    	final int[] result = new int[nums.length - k + 1];
    	
    	for (int i = 0; i < k; i++) {
    		window.addLast(nums[i]);
		}
    	
    	result[0] = Collections.max(window);
    	
    	for (int i = k; i < nums.length; i++) {
			window.removeFirst();
			window.addLast(nums[i]);
			
			result[i - k + 1] = Collections.max(window);
		}
    	
    	return result;
    }
}