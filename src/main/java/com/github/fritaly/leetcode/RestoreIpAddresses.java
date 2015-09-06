package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RestoreIpAddresses {
	
	private static void process(Set<String> result, String s, String prefix, int count) {
		if ((count == 0) || (s.length() > count * 3)) {
			// Do nothing
		} else if (count == 1) {
			if (s.length() <= 3) {
				final int n = Integer.parseInt(s);
				
				if (((n == 0) && (s.length() > 1)) || ((n > 0) && s.startsWith("0"))) {
					return;
				}
				
				if ((0 <= n) && (n <= 255)) {
					result.add(String.format("%s.%s", prefix, s));
				}
			}
		} else {
			if (s.length() >= count) {
				for (int i = 0; i <= s.length() - count; i++) {
					final String start = s.substring(0, i + 1);
					final int n = Integer.parseInt(start);
					
					if (((n == 0) && (start.length() > 1)) || ((n > 0) && start.startsWith("0"))) {
						continue;
					}
					
					if ((0 <= n) && (n <= 255)) {
						final String p = "".equals(prefix) ? start : String.format("%s.%s", prefix, start);
								
						process(result, s.substring(i + 1), p, count - 1);
					}
				}
			}
		}
	}

    public List<String> restoreIpAddresses(String s) {
        final Set<String> result = new TreeSet<String>();
        
        process(result, s, "", 4);
        
        return new ArrayList<String>(result);
    }
}