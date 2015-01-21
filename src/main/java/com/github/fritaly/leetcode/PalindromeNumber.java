package com.github.fritaly.leetcode;

public class PalindromeNumber {

	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}

	public boolean isPalindrome(int x) {
		final String text = Integer.toString(x);

		return text.equals(reverse(text));
	}
}
