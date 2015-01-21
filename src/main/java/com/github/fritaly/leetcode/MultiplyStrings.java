package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    private static String reverse(String string) {
    	return new StringBuilder(string).reverse().toString();
    }

    private String add(String num1, String num2) {
    	final StringBuilder buffer = new StringBuilder();

    	num1 = reverse(num1);
    	num2 = reverse(num2);

    	boolean carryOver = false;

    	for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
    		final int digit1 = (i < num1.length()) ? num1.charAt(i) - '0' : 0;
    		final int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0;

    		int sum = digit1 + digit2;

    		if (carryOver) {
    			sum++;

    			carryOver = false;
    		}

    		buffer.append(sum % 10);

    		carryOver = (sum >= 10);
		}

    	if (carryOver) {
    		buffer.append("1");
    	}

    	// Remove trailing zeroes
    	while ((buffer.charAt(buffer.length() - 1) == '0') && (buffer.length() > 1)) {
    		buffer.setLength(buffer.length() - 1);
    	}

    	return reverse(buffer.toString());
    }

	public String multiply(String num1, String num2) {
        final List<String> queue = new ArrayList<>();
        final StringBuilder buffer = new StringBuilder();

        for (int i = num1.length() - 1; i >= 0; i--) {
			final int digit1 = num1.charAt(i) - '0';

			for (int n = 0; n < (num1.length() - 1 - i); n++) {
				buffer.append("0");
			}

			int carryOver = 0;

			for (int j = num2.length() - 1; j >= 0; j--) {
				final int digit2 = num2.charAt(j) - '0';
				final int product = digit1 * digit2 + carryOver;

				buffer.append(product % 10);

				carryOver = (product / 10);
			}

			if (carryOver > 0) {
				buffer.append(carryOver);
			}

			queue.add(reverse(buffer.toString()));

			buffer.setLength(0);
		}

		String result = "0";

		for (String element : queue) {
			result = add(result, element);
		}

		// Remove trailing zeroes
    	while (result.startsWith("0") && (result.length() > 1)) {
    		result = result.substring(1);
    	}

		return result;
    }
}