package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContainsDuplicate2 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		final Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		
		for (int i = 0; i < nums.length; i++) {
			List<Integer> indices = map.get(nums[i]);
			
			if (indices == null) {
				map.put(nums[i], indices = new ArrayList<Integer>());
			}
			
			indices.add(i);
		}

		for (List<Integer> indices : map.values()) {
			for (int i = 0; i < indices.size() - 1; i++) {
				if (indices.get(i + 1) - indices.get(i) <= k) {
					return true;
				}
			}
		}
		
		return false;
	}
}