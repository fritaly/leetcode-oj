package com.github.fritaly.leetcode;

public class RotateList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private static int size(ListNode head) {
		if (head == null) {
			return 0;
		}

		int size = 0;

		do {
			size++;
		} while ((head = head.next) != null);

		return size;
	}

	private static ListNode getNth(ListNode head, int nth) {
		if (head == null) {
			return null;
		}

		for (int i = 1; i < nth; i++) {
			head = head.next;
		}

		return head;
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		final int size = size(head);

		n %= size;

		final ListNode nth = getNth(head, size - n);
		final ListNode last = getNth(head, size);

		last.next = head;

		final ListNode result = nth.next;

		nth.next = null;

		return result;
	}
}