package com.github.fritaly.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class SingleNumber2 {
	public int singleNumber(int[] nums) {
		final Set<Integer> added = new TreeSet<Integer>();
		
		int totalAll = 0, totalUnique = 0;
		
		for (int i : nums) {
			totalAll += i;
			
			if (added.add(i)) {
				totalUnique += i;
			}
		}
		
		return (totalAll - 3 * ((totalAll - totalUnique) / 2));
	}
}