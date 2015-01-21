package com.github.fritaly.leetcode;

public class MergeTwoSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if ((l1 == null) && (l2 == null)) {
			return null;
		}

		ListNode next1 = l1;
		ListNode next2 = l2;

		ListNode current = null;
		ListNode result = null;

		do {
			if ((next1 == null) || ((next2 != null) && (next1.val > next2.val))) {
				if (current != null) {
					current = current.next = next2;
				} else {
					result = current = next2;
				}

				next2 = next2.next;
			} else if ((next2 == null) || (next1.val <= next2.val)) {
				if (current != null) {
					current = current.next = next1;
				} else {
					result = current = next1;
				}

				next1 = next1.next;
			}
		} while ((next1 != null) || (next2 != null));

		return result;
	}
}