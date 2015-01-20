package com.github.fritaly.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
    	final Map<Integer, Integer> indices = new LinkedHashMap<>();

    	for (int i = 0; i < numbers.length; i++) {
			indices.put(numbers[i], i);
		}

    	for (int i = 0; i < numbers.length; i++) {
			final int i1 = numbers[i];
			final int diff = target - i1;

			final Integer index2 = indices.get(diff);

			if ((index2 != null) && (index2 != -1) && (index2 != i)) {
				return new int[] { i + 1, index2 + 1 };
			}
		}

    	throw new RuntimeException("No match found");
    }
}