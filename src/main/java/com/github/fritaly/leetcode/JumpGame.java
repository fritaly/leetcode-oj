package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class JumpGame {

	public boolean canJump(int[] nums) {
		// List of indexes which can reach the last index
		final LinkedList<Integer> solutions = new LinkedList<Integer>();

		for (int i = nums.length - 1; i >= 0; i--) {
			final int maxJump = nums[i];

			if (i + maxJump >= nums.length - 1) {
				solutions.addFirst(i);
			} else if (i + maxJump >= solutions.getFirst()) {
				solutions.addFirst(i);
			}
		}

		return solutions.getFirst() == 0;
	}
}