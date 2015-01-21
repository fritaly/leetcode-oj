package com.github.fritaly.leetcode;

public class AddBinary {

	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}

	public String addBinary(String a, String b) {
		final StringBuilder buffer = new StringBuilder();

		a = reverse(a);
		b = reverse(b);

		boolean carryOver = false;

		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			final int c1 = (i < a.length()) ? a.charAt(i) - '0' : 0;
			final int c2 = (i < b.length()) ? b.charAt(i) - '0' : 0;

			int sum = c1 + c2;

			if (carryOver) {
				sum++;

				carryOver = false;
			}

			buffer.append(sum % 2);

			carryOver = (sum >= 2);
		}

		if (carryOver) {
			buffer.append('1');
		}

		return buffer.reverse().toString();
	}
}