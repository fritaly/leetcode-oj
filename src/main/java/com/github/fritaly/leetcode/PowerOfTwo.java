package com.github.fritaly.leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
    	return (n >= 0) && "1".equals(Integer.toBinaryString(n).replaceAll("0", ""));
    }
}