package com.github.fritaly.leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
    	// The initial carry over represents the +1
    	boolean carryOver = true;

    	for (int i = digits.length - 1; i >= 0; i--) {
    		if (carryOver) {
    			digits[i] += 1;

    			carryOver = false;
    		}

    		if (digits[i] >= 10) {
    			digits[i] %= 10;

    			carryOver = true;
    		}
		}

    	if (carryOver) {
    		final int[] array = new int[digits.length + 1];
    		array[0] = 1;

    		System.arraycopy(digits, 0, array, 1, digits.length);

			return array;
    	}

    	return digits;
    }
}