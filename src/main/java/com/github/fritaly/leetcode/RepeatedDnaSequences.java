package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
    	final Map<String, java.util.concurrent.atomic.AtomicInteger> map = new TreeMap<String, java.util.concurrent.atomic.AtomicInteger>();
    	
    	for (int i = 0; i <= s.length() - 10; i++) {
			final String substring = s.substring(i, i + 10);
			
			if (!map.containsKey(substring)) {
				map.put(substring, new java.util.concurrent.atomic.AtomicInteger(1));
			} else {
				map.get(substring).incrementAndGet();
			}
		}
    	
    	final List<String> result = new ArrayList<String>();
    	
    	for (Map.Entry<String, java.util.concurrent.atomic.AtomicInteger> entry : map.entrySet()) {
			if (entry.getValue().get() > 1) {
				result.add(entry.getKey());
			}
		}
    	
    	return result;
    }
}