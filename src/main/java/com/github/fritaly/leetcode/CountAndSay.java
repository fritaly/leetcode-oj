package com.github.fritaly.leetcode;

public class CountAndSay {

	public String countAndSay(int n) {
		String current = "1";

		final StringBuilder buffer = new StringBuilder();

		for (int i = 1; i < n; i++) {
			char previous = ' ';
			int count = 0;

			for (char c : current.toCharArray()) {
				if (previous == ' ') {
					previous = c;
					count++;
				} else if (previous != c) {
					buffer.append(count).append(previous);

					previous = c;
					count = 1;
				} else if (previous == c) {
					count++;
				}
			}

			buffer.append(count).append(previous);

			current = buffer.toString();
			buffer.setLength(0);
		}

		return current;
	}
}