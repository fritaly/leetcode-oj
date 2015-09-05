package com.github.fritaly.leetcode;

import java.util.Arrays;

public class ValidAnagram {
	private static String sort(String s) {
		final char[] chars = s.toCharArray();
		
		Arrays.sort(chars);
		
		return new String(chars);
	}
	
    public boolean isAnagram(String s, String t) {
    	return (s.length() == t.length()) && sort(s).equals(sort(t));
    }
}