package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	private static long factorial(int n) {
		return (n == 0) ? 1 : n * factorial(n - 1);
	}

    public String getPermutation(int n, int k) {
    	final List<Character> digits = new ArrayList<>();

    	for (int i = 1; i <= n; i++) {
    		digits.add(Character.valueOf((char) ('0' + i)));
		}

    	final StringBuilder buffer = new StringBuilder();

    	k--;

    	while (k > 0) {
    		final long factorial = factorial(digits.size() - 1);
			final long ratio = k / factorial;

			buffer.append(digits.remove((int) ratio));

			k -= (ratio * factorial);
    	}

    	for (Character digit : digits) {
			buffer.append(digit);
		}

    	return buffer.toString();
    }
}