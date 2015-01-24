package com.github.fritaly.leetcode;


public class ZigZagConversion {

	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}

		final StringBuilder[] builders = new StringBuilder[nRows];

		for (int i = 0; i < nRows; i++) {
			builders[i] = new StringBuilder();
		}

		boolean forward = true;

		int index = 0;

		for (char c : s.toCharArray()) {
			builders[index].append(c);

			if (forward) {
				index++;
			} else {
				index--;
			}

			if ((index == 0) && !forward) {
				forward = true;
			} else if ((index == builders.length - 1) && forward) {
				forward = false;
			}
		}

		index = 0;

		final StringBuilder builder = new StringBuilder();

		for (StringBuilder buffer : builders) {
			builder.append(buffer);
		}

		return builder.toString();
	}
}
