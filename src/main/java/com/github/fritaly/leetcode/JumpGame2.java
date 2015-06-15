package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class JumpGame2 {

	private static class Data {
		final int index, jumps;

		public Data(int index, int jumps) {
			this.index = index;
			this.jumps = jumps;
		}
	}

	public int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}

		// Number of jumps necessary from a given index to reach the last index
		final LinkedList<Data> jumps = new LinkedList<Data>();

		for (int i = nums.length - 1; i >= 0; i--) {
			final int maxJump = nums[i];

			if (i + maxJump >= nums.length - 1) {
				// This index can reach the last index directly
				jumps.addFirst(new Data(i, 1));
			} else if (i + maxJump >= jumps.getFirst().index) {
				// Determine the jump to reach the last index as fast as possible
				int best = Integer.MAX_VALUE;

				for (Data data : jumps) {
					if (i + maxJump < data.index) {
						break;
					}

					best = Math.min(best, data.jumps + 1);
				}

				if (jumps.getFirst().jumps == best) {
					// Remove the current first index which isn't better than the new one
					jumps.removeFirst();
				}

				jumps.addFirst(new Data(i, best));
			}
		}

		return jumps.getFirst().jumps;
	}
}