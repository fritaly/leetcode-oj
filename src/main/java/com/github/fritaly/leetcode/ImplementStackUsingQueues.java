package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class ImplementStackUsingQueues {

	private final LinkedList<Integer> queue = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		queue.addLast(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		final LinkedList<Integer> buffer = new LinkedList<Integer>();
		
		while (queue.size() > 1) {
			buffer.addLast(queue.removeFirst());
		}
		
		queue.removeLast();
		
		while (!buffer.isEmpty()) {
			queue.addLast(buffer.removeFirst());
		}
	}

	// Get the top element.
	public int top() {
		final LinkedList<Integer> buffer = new LinkedList<Integer>();
		
		while (queue.size() > 1) {
			buffer.addLast(queue.removeFirst());
		}
		
		final int value = queue.removeLast();
		
		buffer.addLast(value);
		
		while (!buffer.isEmpty()) {
			queue.addLast(buffer.removeFirst());
		}
		
		return value;
	}

	// Return whether the stack is empty.
	public boolean empty() {
    	return queue.isEmpty();
    }
}