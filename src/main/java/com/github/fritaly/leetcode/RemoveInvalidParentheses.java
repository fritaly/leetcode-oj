package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveInvalidParentheses {

	private boolean isValid(String s) {
		int score = 0;
		
		for (char c : s.toCharArray()) {
			if (c == '(') {
				score++;
			} else if (c == ')') {
				score--;
			} else if ((('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z'))) {
				// Skip letters
			}
			
			if (score < 0) {
				return false;
			}
		}
		
		return (score == 0);
	}
	
	private int getScore(String s) {
		int score = 0;
		
		for (char c : s.toCharArray()) {
			if (c == '(') {
				score++;
			} else if (c == ')') {
				score--;
			} else if ((('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z'))) {
				// Skip letters
			}
		}
		
		return score;
	}
	
	private String removeChar(String s, int i) {
		if (i == 0) {
			return s.length() > 1 ? s.substring(1) : "";
		}
		if (i == s.length() - 1) {
			return s.substring(0, s.length() - 1);
		}
		
		return s.substring(0, i) + s.substring(i + 1);
	}
	
    public List<String> removeInvalidParentheses(String s) {
        final Set<String> result = new TreeSet<String>();
        
        final int score = getScore(s);

        if (score == 0) {
        	if (isValid(s)) {
        		result.add(s);
        	}
        } else if (score > 0) {
        	// Remove n opening parentheses
        	for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					result.addAll(removeInvalidParentheses(removeChar(s, i)));
				}
			}
        } else if (score < 0) {
        	// Remove n closing parentheses
        	for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					result.addAll(removeInvalidParentheses(removeChar(s, i)));
				}
			}
        }
        
		return new ArrayList<String>(result);
    }
    
    public static void main(String[] args) {
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(")("));
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("((()((s((((()"));
	}
}