package com.github.fritaly.leetcode;

public class SingleNumber {

    public int singleNumber(int[] A) {
    	int result = 0;
    	
    	for (int i : A) {
			result ^= i;
		}
    	
    	return result;
    }
}