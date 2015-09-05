package com.github.fritaly.leetcode;

public class AddDigits {

	public int addDigits(int num) {
		int sum = 0;
		
		for (char c : Integer.toString(num).toCharArray()) {
			sum += (c - '0');
		}
		
		return (sum >= 10) ? addDigits(sum) : sum;
	}
}