package com.github.fritaly.leetcode;

import java.util.Arrays;

public class MajorityElement {

	public int majorityElement(int[] num) {
		Arrays.sort(num);

		// The middle element is necessarily the majority element
		return num[num.length / 2];
	}
}
