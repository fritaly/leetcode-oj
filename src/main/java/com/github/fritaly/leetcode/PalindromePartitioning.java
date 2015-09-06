package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {

	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}
	
	private static boolean isPalindrome(String string) {
		return (string.length() == 1) || string.equals(reverse(string));
	}

    public List<List<String>> partition(String s) {
    	if (s.length() == 1) {
    		return Collections.singletonList(Collections.singletonList(s));
    	}
    	
        final List<List<String>> result = new ArrayList<List<String>>();
        
        if (isPalindrome(s)) {
        	result.add(Collections.singletonList(s));
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
			final String start = s.substring(0, i + 1);
			
			if (isPalindrome(start)) {
				final List<List<String>> result2 = partition(s.substring(i + 1));
				
				for (List<String> list : result2) {
					final List<String> list2 = new ArrayList<String>();
					list2.add(start);
					list2.addAll(list);
					
					result.add(list2);
				}
			}
		}
        
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("aab"));
		System.out.println(new PalindromePartitioning().partition("bb"));
	}
}