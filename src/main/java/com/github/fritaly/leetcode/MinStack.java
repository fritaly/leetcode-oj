package com.github.fritaly.leetcode;

public class MinStack {

	private static class Node {
		final int val;

		int min;

		Node previous = null;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node head;

	public void push(int value) {
		final Node node = new Node(value);
		node.previous = head;
		node.min = (head != null) ? Math.min(head.min, node.val) : node.val;

		this.head = node;
	}

	public void pop() {
		if (head != null) {
			head = head.previous;
		}
	}

	public int top() {
		return (head != null) ? head.val : 0;
	}

	public int getMin() {
		return (head != null) ? head.min : 0;
	}
}