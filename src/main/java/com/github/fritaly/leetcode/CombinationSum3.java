package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		final Map<Integer, List<List<Integer>>> map = new TreeMap<Integer, List<List<Integer>>>();
		map.put(0, new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>())));

		for (int i = 1; i <= 9; i++) {
			final Map<Integer, List<List<Integer>>> buffer = new TreeMap<Integer, List<List<Integer>>>();
			
			for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
				final int value = entry.getKey();
				final List<List<Integer>> combinations = entry.getValue();
				
				// Generate a new value by combining i to the current value
				final int newValue = value + i;
				final List<List<Integer>> newCombinations = new ArrayList<List<Integer>>();
				
				for (List<Integer> combination : combinations) {
					final List<Integer> newCombination = new ArrayList<Integer>(combination);
					newCombination.add(i);
					
					newCombinations.add(newCombination);
				}
				
				if (!buffer.containsKey(newValue)) {
					buffer.put(newValue, new ArrayList<List<Integer>>());
				}
				
				buffer.get(newValue).addAll(newCombinations);
			}
			
			for (Integer value : buffer.keySet()) {
				final List<List<Integer>> combinations = buffer.get(value);
				
				if (!map.containsKey(value)) {
					map.put(value, new ArrayList<List<Integer>>());
				}
				
				map.get(value).addAll(combinations);
			}
		}
		
		final List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (map.containsKey(n)) {
			for (List<Integer> combination : map.get(n)) {
				if (combination.size() == k) {
					result.add(combination);
				}
			}	
		}

		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new CombinationSum3().combinationSum3(3, 9));
	}
}