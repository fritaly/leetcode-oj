package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {

	private static List<String> getLetters(char digit) {
		switch (digit) {
		case '2':
			return Arrays.asList("a", "b", "c");
		case '3':
			return Arrays.asList("d", "e", "f");
		case '4':
			return Arrays.asList("g", "h", "i");
		case '5':
			return Arrays.asList("j", "k", "l");
		case '6':
			return Arrays.asList("m", "n", "o");
		case '7':
			return Arrays.asList("p", "q", "r", "s");
		case '8':
			return Arrays.asList("t", "u", "v");
		case '9':
			return Arrays.asList("w", "x", "y", "z");
		default:
			throw new IllegalArgumentException("Unsupported digit: " + digit);
		}
	}

	public List<String> letterCombinations(String digits) {
		if ("".equals(digits)) {
			return Collections.singletonList("");
		}
		if (digits.length() == 1) {
			return getLetters(digits.charAt(0));
		}

		final List<String> result = new ArrayList<>();

		for (String letter : getLetters(digits.charAt(0))) {
			for (String suffix : letterCombinations(digits.substring(1))) {
				result.add(letter + suffix);
			}
		}

		return result;
	}
}