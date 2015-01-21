package com.github.fritaly.leetcode;

public class ValidPalindrome {

	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}

	public boolean isPalindrome(String s) {
		final String string = s.replaceAll("[^a-zA-Z0-9]+", "");

		return string.equalsIgnoreCase(reverse(string));
	}
}
