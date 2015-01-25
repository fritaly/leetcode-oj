package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class FractionToRecurringDecimal {

	public String fractionToDecimal(int _numerator, int _denominator) {
		// Use long variables for internal representation
		long numerator = _numerator, denominator = _denominator;

		final StringBuilder buffer = new StringBuilder();

		if (denominator < 0) {
			// Ensure the denominator is always positive
			denominator = -denominator;
			numerator = -numerator;
		}
		if (numerator < 0) {
			numerator = -numerator;

			buffer.append("-");
		}

		buffer.append(numerator / denominator);

		// Get rid of the minus sign (if any)
		long remainder = Math.abs((numerator % denominator) * 10);

		final LinkedList<String> keys = new LinkedList<>();

		if (remainder != 0) {
			buffer.append(".");

			while (remainder != 0) {
				final long quotient = remainder / denominator;

				remainder = (remainder % denominator) * 10;

				final String key = String.format("%d:%d", quotient, remainder);

				if (keys.contains(key)) {
					// There's a repeating pattern in the decimal part
					int offset = 0;

					while (!keys.removeLast().equals(key)) {
						offset++;
					}

					buffer.insert(buffer.length() - offset - 1, "(");
					buffer.append(")");
					break;
				} else {
					keys.add(key);
				}

				buffer.append(quotient);
			}
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 2));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(2, 1));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(2, 3));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(22, 7));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 333));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-50, 8));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(7, -12));
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
	}
}