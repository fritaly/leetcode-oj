package com.github.fritaly.leetcode;

public class IntegerToRoman {

	public String intToRoman(int num) {
		final StringBuilder buffer = new StringBuilder();

		while (num > 0) {
			if (num >= 1000) {
				buffer.append("M");

				num -= 1000;
			} else if (num >= 900) {
				buffer.append("CM");

				num -= 900;
			} else if (num >= 500) {
				buffer.append("D");

				num -= 500;
			} else if (num >= 400) {
				buffer.append("CD");

				num -= 400;
			} else if (num >= 100) {
				buffer.append("C");

				num -= 100;
			} else if (num >= 90) {
				buffer.append("XC");

				num -= 90;
			} else if (num >= 50) {
				buffer.append("L");

				num -= 50;
			} else if (num >= 40) {
				buffer.append("XL");

				num -= 40;
			} else if (num >= 10) {
				buffer.append("X");

				num -= 10;
			} else if (num >= 9) {
				buffer.append("IX");

				num -= 9;
			} else if (num >= 5) {
				buffer.append("V");

				num -= 5;
			} else if (num >= 4) {
				buffer.append("IV");

				num -= 4;
			} else if (num >= 1) {
				buffer.append("I");

				num -= 1;
			}
		}

		return buffer.toString();
	}
}