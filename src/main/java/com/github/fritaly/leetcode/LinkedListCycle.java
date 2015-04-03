package com.github.fritaly.leetcode;

public class LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		while (head != null) {
			if (head.val == head.hashCode()) {
				return true;
			}
			
			head.val = head.hashCode();
			head = head.next;
		}
		
		return false;
	}
}