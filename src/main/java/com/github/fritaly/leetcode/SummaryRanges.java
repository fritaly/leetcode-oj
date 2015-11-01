package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

	private static class Range {
		int start, end;

		public Range(int n) {
			this.start = this.end = n;
		}

		@Override
		public String toString() {
			return (start == end) ? Integer.toString(start) : String.format(
					"%d->%d", start, end);
		}
	}

	public List<String> summaryRanges(int[] nums) {
		final LinkedList<Range> ranges = new LinkedList<Range>();

		for (int i = 0; i < nums.length; i++) {
			final int n = nums[i];

			if (ranges.isEmpty()) {
				ranges.add(new Range(n));
			} else {
				if (ranges.getLast().end + 1 == n) {
					ranges.getLast().end++;
				} else {
					ranges.add(new Range(n));
				}
			}
		}

		final List<String> result = new ArrayList<String>();
		
		for (Range range: ranges) {
			result.add(range.toString());
		}

		return result;
	}
}