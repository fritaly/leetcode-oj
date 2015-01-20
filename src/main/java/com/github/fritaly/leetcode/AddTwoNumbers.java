package com.github.fritaly.leetcode;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode current = null;

		boolean carryOver = false;

		while ((l1 != null) || (l2 != null) || carryOver) {
			final int d1 = (l1 != null) ? l1.val : 0;
			final int d2 = (l2 != null) ? l2.val : 0;

			int d = d1 + d2;

			if (carryOver) {
				d++;

				carryOver = false;
			}

			if (d >= 10) {
				d %= 10;
				carryOver = true;
			}

			final ListNode node = new ListNode(d);

			if (current != null) {
				current.next = node;
			} else {
				result = node;
			}

			current = node;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return result;
	}
}