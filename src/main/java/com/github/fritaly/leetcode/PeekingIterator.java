package com.github.fritaly.leetcode;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	private final Iterator<Integer> iterator;
	
	private Integer element;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (element == null) {
			if (iterator.hasNext()) {
				element = iterator.next();
			}
		}
		
		return element;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (element != null) {
			final int result = element;
			
			element = null;
			
			return result;
		}
		
		return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return (element != null) || iterator.hasNext();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}