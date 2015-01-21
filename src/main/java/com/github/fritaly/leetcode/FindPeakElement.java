package com.github.fritaly.leetcode;

public class FindPeakElement {

	public int findPeakElement(int[] num) {
		int result = 0;

		for (int i = 0; i < num.length - 1; i++) {
			if (num[i + 1] > num[i]) {
				result = i + 1;
			}
		}

		return result;
	}
}