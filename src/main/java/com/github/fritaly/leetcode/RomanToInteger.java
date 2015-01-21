package com.github.fritaly.leetcode;

public class RomanToInteger {

	public int romanToInt(String s) {
		int result = 0;

		while (s.length() > 0) {
			if (s.startsWith("M")) {
				result += 1000;

				s = s.substring(1);
			} else if (s.startsWith("CM")) {
				result += 900;

				s = s.substring(2);
			} else if (s.startsWith("D")) {
				result += 500;

				s = s.substring(1);
			} else if (s.startsWith("CD")) {
				result += 400;

				s = s.substring(2);
			} else if (s.startsWith("C")) {
				result += 100;

				s = s.substring(1);
			} else if (s.startsWith("XC")) {
				result += 90;

				s = s.substring(2);
			} else if (s.startsWith("L")) {
				result += 50;

				s = s.substring(1);
			} else if (s.startsWith("XL")) {
				result += 40;

				s = s.substring(2);
			} else if (s.startsWith("X")) {
				result += 10;

				s = s.substring(1);
			} else if (s.startsWith("IX")) {
				result += 9;

				s = s.substring(2);
			} else if (s.startsWith("V")) {
				result += 5;

				s = s.substring(1);
			} else if (s.startsWith("IV")) {
				result += 4;

				s = s.substring(2);
			} else if (s.startsWith("I")) {
				result += 1;

				s = s.substring(1);
			} else {
				throw new IllegalArgumentException("Invalid roman number: " + s);
			}
		}

		return result;
	}
}