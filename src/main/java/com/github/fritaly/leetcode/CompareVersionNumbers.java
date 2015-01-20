package com.github.fritaly.leetcode;

public class CompareVersionNumbers {

	private static int[] toArrayOfInts(String[] strings) {
		final int[] array = new int[strings.length];

		for (int i = 0; i < strings.length; i++) {
			array[i] = Integer.parseInt(strings[i]);
		}

		return array;
	}

	public int compareVersion(String version1, String version2) {
		final int[] digits1 = toArrayOfInts(version1.split("\\."));
		final int[] digits2 = toArrayOfInts(version2.split("\\."));

		for (int i = 0; i < Math.max(digits1.length, digits2.length); i++) {
			final int digit1 = (i < digits1.length) ? digits1[i] : 0;
			final int digit2 = (i < digits2.length) ? digits2[i] : 0;

			if (digit1 > digit2) {
				return +1;
			} else if (digit1 < digit2) {
				return -1;
			}
		}

		return 0;
	}
}
