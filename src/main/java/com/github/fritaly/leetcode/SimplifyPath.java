package com.github.fritaly.leetcode;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		final String[] chunks = path.split("/");

		final Stack<String> stack = new Stack<>();

		for (String chunk : chunks) {
			if ("".equals(chunk) || ".".equals(chunk)) {
				continue;
			}
			if ("..".equals(chunk)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(chunk);
			}
		}

		final StringBuilder buffer = new StringBuilder();

		for (String string : stack) {
			buffer.append("/").append(string);
		}

		return (buffer.length() == 0) ? "/" : buffer.toString();
	}
}