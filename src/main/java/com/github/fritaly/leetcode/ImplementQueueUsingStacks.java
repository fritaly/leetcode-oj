package com.github.fritaly.leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	private final Stack<Integer> stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
    	stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        final Stack<Integer> buffer = new Stack<Integer>();
        
        while (stack.size() > 1) {
        	buffer.push(stack.pop());
        }
        
        stack.clear();
        
        while (!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
    }

    // Get the front element.
    public int peek() {
        final Stack<Integer> buffer = new Stack<Integer>();
        
        while (stack.size() > 1) {
        	buffer.push(stack.pop());
        }
        
        final int value = stack.peek();
        
        while (!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
        
        return value;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}