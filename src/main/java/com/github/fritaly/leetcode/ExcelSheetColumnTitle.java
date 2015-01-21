package com.github.fritaly.leetcode;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		final StringBuilder builder = new StringBuilder();

		do {
			n--;

			final int remainder = n % 26;

			builder.append((char) ('A' + remainder));

			n /= 26;
		} while (n > 0);

		builder.reverse();

		return builder.toString();
	}
}