package com.github.fritaly.leetcode;

import java.util.Arrays;

public class CountPrimes {

    public int countPrimes(int n) {
    	if (n < 2) {
    		return 0;
    	}
    	
    	final boolean[] array = new boolean[n + 1];
    	
    	Arrays.fill(array, true);
    	
    	int count = 0;
    	int index = 2;
    	
    	while (index < n) {
    		if (array[index]) {
    			count++;
    			
    			for (int i = index; i < n; i += index) {
					array[i] = false;
				}
    		}
    		
    		index++;
    	}
    	
    	return count;
    }
}