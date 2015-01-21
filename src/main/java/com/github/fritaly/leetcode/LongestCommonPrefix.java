package com.github.fritaly.leetcode;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		String prefix = null;

		for (String string : strs) {
			if (prefix == null) {
				prefix = string;
			} else {
				if (string.length() < prefix.length()) {
					prefix = prefix.substring(0, string.length());
				}

				for (int i = 0; i < Math.min(prefix.length(), string.length()); i++) {
					if (string.charAt(i) != prefix.charAt(i)) {
						prefix = string.substring(0, i);
						break;
					}
				}
			}
		}

		return (prefix == null) ? "" : prefix;
	}
}