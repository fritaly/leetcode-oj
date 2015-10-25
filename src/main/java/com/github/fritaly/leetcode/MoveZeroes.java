package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        final LinkedList<Integer> indices = new LinkedList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				indices.add(i);
			}
		}
        
        int i = 0;
        
        for (Integer index : indices) {
			nums[i++] = nums[index];
		}
        
        while (i < nums.length) {
        	nums[i++] = 0;
        }
    }
}