package com.github.fritaly.leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
    	final Stack<Character> stack = new Stack<>();

    	for (char c : s.toCharArray()) {
			switch(c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (stack.pop() != '[') {
					return false;
				}
				break;
			}
    	}

    	return stack.isEmpty();
    }
}
