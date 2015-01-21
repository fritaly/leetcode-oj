package com.github.fritaly.leetcode;

public class StringToInteger {

	private final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[+-]?([0-9]+)([^0-9]+.*)?");

	public int atoi(String str) {
		str = str.trim();

		final java.util.regex.Matcher matcher = pattern.matcher(str);

		if (!matcher.matches()) {
			return 0;
		}

		final boolean negative = str.startsWith("-");

		java.math.BigInteger result = java.math.BigInteger.ZERO;

		for (char c : matcher.group(1).toCharArray()) {
			result = result.multiply(java.math.BigInteger.TEN);
			result = result.add(java.math.BigInteger.valueOf(c - '0'));
		}

		if (negative) {
			result = result.multiply(java.math.BigInteger.valueOf(-1));
		}

		result = result.max(java.math.BigInteger.valueOf(Integer.MIN_VALUE));
		result = result.min(java.math.BigInteger.valueOf(Integer.MAX_VALUE));

		return result.intValue();
	}
}