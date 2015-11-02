package com.github.fritaly.leetcode;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
    	if (haystack.equals(needle)) {
    		return 0;
    	}
    	
    	for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
    		boolean found = true;
    		
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					found = false;
					break;
				}
			}
			
			if (found) {
				return i;
			}
		}
    	
    	return -1;
    }
}