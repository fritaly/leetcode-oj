package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsomorphicStrings {

	private static String form(String string) {
		final StringBuilder buffer = new StringBuilder();
		
		final List<Character> characters = new ArrayList<Character>();
		
		boolean first = true;
		
		for (char c : string.toCharArray()) {
			if (!first) {
				buffer.append(':');
			}
			
			int index = characters.indexOf(c);
			
			if (index == -1) {
				index = characters.size();
				
				characters.add(c);
			}
			
			buffer.append(index);
			
			first = false;
		}
		
		return buffer.toString();
	}
	
	public boolean isIsomorphic(String s, String t) {
		return form(s).equals(form(t));
	}
}