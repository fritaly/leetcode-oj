package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {

	private static String normalize(String string) {
		final char[] chars = string.toCharArray();
		
		Arrays.sort(chars);

		return new String(chars);
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	final Map<String, List<String>> map = new TreeMap<String, List<String>>();
    	
    	for (String string : strs) {
			final String key = normalize(string);
			
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			
			map.get(key).add(string);
		}
    	
    	final List<List<String>> result = new ArrayList<List<String>>();

    	for (List<String> list : map.values()) {
    		Collections.sort(list);
    		
			result.add(new ArrayList<String>(list));
		}
    	
    	return result;
    }
}