package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Combinations {
	
	private static List<Integer> combine(List<Integer> list, int value) {
		final List<Integer> result = new ArrayList<Integer>(list);
		result.add(value);
		
		return result;
	}

	private static void combine(Set<Integer> all, List<Integer> list, int remaining, List<List<Integer>> result) {
		if (remaining == 0) {
			result.add(list);
			
			return;
		}
		if (remaining == 1) {
			for (Integer value : all) {
				result.add(combine(list, value));
			}
			
			return;
		}

		final Set<Integer> newAll = new TreeSet<Integer>(all);
		
		for (Integer value : all) {
			newAll.remove(value);
			
			combine(newAll, combine(list, value), remaining - 1, result);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
		final List<List<Integer>> result = new ArrayList<List<Integer>>();

		final Set<Integer> all = new TreeSet<Integer>();
		
		for (int i = 1; i <= n; i++) {
			all.add(i);
		}
		
		combine(all, new ArrayList<Integer>(), k, result);
		
		return result;
	}
}