package com.github.fritaly.leetcode;

public class PartitionList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	private static String dump(ListNode node) {
		final StringBuilder buffer = new StringBuilder();

		boolean first = true;

		while (node != null) {
			if (first) {
				first = false;
			} else {
				buffer.append(" -> ");
			}

			buffer.append(node.val);

			node = node.next;
		}

		return buffer.toString();
	}

	private static ListNode create(int[] values) {
		ListNode node = null, first = null;

		for (int value : values) {
			if (node == null) {
				first = node = new ListNode(value);
			} else {
				node = node.next = new ListNode(value);
			}
		}

		return first;
	}

	public ListNode partition(ListNode head, int x) {
		ListNode firstLesser = null, lesser = null, firstGreater = null, greater = null;

		while (head != null) {
			if (head.val < x) {
				if (lesser == null) {
					firstLesser = lesser = head;
				} else {
					lesser = lesser.next = head;
				}
			} else {
				if (greater == null) {
					firstGreater = greater = head;
				} else {
					greater = greater.next = head;
				}
			}

			head = head.next;

			if (lesser != null) {
				lesser.next = null;
			}
			if (greater != null) {
				greater.next = null;
			}
		}

		if (lesser != null) {
			lesser.next = firstGreater;
		}

		return (firstLesser != null) ? firstLesser : firstGreater;
	}

	public static void main(String[] args) {
		System.out.println(dump(new PartitionList().partition(create(new int[] { 1, 4, 3, 2, 5, 2 }), 3)));
		System.out.println(dump(new PartitionList().partition(create(new int[] { 1 }), 0)));
	}
}