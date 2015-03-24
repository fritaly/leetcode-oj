package com.github.fritaly.leetcode;

public class NumberOfOneBits {

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		return Integer.toBinaryString(n).replaceAll("0", "").length();
	}
}