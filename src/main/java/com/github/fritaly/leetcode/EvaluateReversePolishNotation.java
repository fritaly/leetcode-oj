package com.github.fritaly.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	private static boolean isOperator(String token) {
		return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
	}

	private static int evaluate(String left, String right, String operator) {
		final int a = Integer.parseInt(left);
		final int b = Integer.parseInt(right);

		if ("+".equals(operator)) {
			return a + b;
		} else if ("-".equals(operator)) {
			return a - b;
		} else if ("*".equals(operator)) {
			return a * b;
		} else if ("/".equals(operator)) {
			return a / b;
		}

		throw new IllegalArgumentException("Unsupported operator: " + operator);
	}

	public int evalRPN(String[] tokens) {
		final Stack<String> stack = new Stack<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				// The pop order matters !
				final String right = stack.pop();
				final String left = stack.pop();

				stack.push(Integer.toString(evaluate(left, right, token)));
			} else {
				stack.push(token);
			}
		}

		return Integer.parseInt(stack.pop());
	}
}