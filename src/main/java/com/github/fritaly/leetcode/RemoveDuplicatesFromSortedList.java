package com.github.fritaly.leetcode;

public class RemoveDuplicatesFromSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode result = null;
		ListNode current = null;

		while (head != null) {
			if (result == null) {
				result = current = new ListNode(head.val);
			} else {
				if (current.val != head.val) {
					current.next = new ListNode(head.val);

					current = current.next;
				}
			}

			head = head.next;
		}

		return result;
	}
}