package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Permutations {

	private static List<List<Integer>> permute(int[] num, List<Integer> start, Set<Integer> indices) {
		if (indices.size() == num.length) {
			return Collections.singletonList(start);
		}

		final List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < num.length; i++) {
			if (indices.contains(i)) {
				continue;
			}

			final Set<Integer> indices2 = new TreeSet<>(indices);
			indices2.add(i);

			final List<Integer> start2 = new ArrayList<>(start);
			start2.add(num[i]);

			result.addAll(permute(num, start2, indices2));
		}

		return result;
	}

	public List<List<Integer>> permute(int[] num) {
		return permute(num, new ArrayList<Integer>(), new TreeSet<Integer>());
	}
}