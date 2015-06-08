package com.github.fritaly.leetcode;

public class ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode last = null, previous = null;

		while (head != null) {
			previous = last;
			last = head;
			head = head.next;
			last.next = previous;
		}

		return last;
	}
}