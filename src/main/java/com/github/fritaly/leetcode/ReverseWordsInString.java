package com.github.fritaly.leetcode;

public class ReverseWordsInString {

	public String reverseWords(String s) {
		final String[] words = s.split("[ ]+");

		final StringBuilder buffer = new StringBuilder();

		boolean first = true;

		for (int i = words.length - 1; i >= 0; i--) {
			if (first) {
				first = false;
			} else {
				buffer.append(" ");
			}

			buffer.append(words[i]);
		}

		return buffer.toString().trim();
	}
}