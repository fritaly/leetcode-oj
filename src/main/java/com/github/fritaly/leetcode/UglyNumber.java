package com.github.fritaly.leetcode;

public class UglyNumber {

    public boolean isUgly(int num) {
    	boolean ugly = true;
    	
    	while (ugly) {
    		if ((num == 1) || (num == 2) || (num == 3) || (num == 5)) {
            	break;
            }	
    		
    		if (num % 2 == 0) {
            	num /= 2;
            } else if (num % 3 == 0) {
            	num /= 3;
            } else if (num % 5 == 0) {
            	num /= 5;
            } else {
            	ugly = false;
            }
    	}
    	
        return ugly;
    }
}