package com.github.fritaly.leetcode;

public class ReverseInteger {

	public int reverse(int x) {
		final StringBuilder buffer = new StringBuilder().append(x).reverse();

		if (buffer.charAt(buffer.length() - 1) == '-') {
			buffer.setLength(buffer.length() - 1);
		}

		final long reverted = Long.parseLong(buffer.toString());

		if (reverted >= Integer.MAX_VALUE) {
			return 0;
		} else if (reverted <= Integer.MIN_VALUE) {
			return 0;
		}

		return (int) ((x < 0) ? -1 * reverted : reverted);
	}
}
