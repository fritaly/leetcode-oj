package com.github.fritaly.leetcode;

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] num) {
		if (num.length == 1) {
			return num[0];
		}

		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] > num[i + 1]) {
				return num[i + 1];
			}
		}

		return -1;
	}
}