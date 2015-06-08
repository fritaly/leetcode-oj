package com.github.fritaly.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class HappyNumber {
	
	private static int next(int n) {
		final String text = Integer.toString(n);
		
		int result = 0;
		
		for (char c : text.toCharArray()) {
			final int digit = c - '0';
			
			result += digit * digit;
		}
		
		return result;
	}

	public boolean isHappy(int n) {
		final Set<Integer> cache = new TreeSet<Integer>();
		
		while (true) {
			if (cache.contains(n)) {
				return false;
			}
			
			final int old = n;
			
			n = next(n);
			
			if (n == 1) {
				break;
			}
			
			cache.add(old);
		}
		
		return true;
	}
}