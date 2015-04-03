package com.github.fritaly.leetcode;

public class ClimbingStairs {
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + ": " + new ClimbingStairs().climbStairs(i));
		}
	}

	public int climbStairs(int n) {
		final int[] table = new int[n + 1];
		table[0] = 1;
		
		for (int i = 1; i < table.length; i++) {
			table[i] = table[i - 1];
			
			if (i >= 2) {
				table[i] += table[i - 2];
			}
		}
		
		return table[n];
	}
}