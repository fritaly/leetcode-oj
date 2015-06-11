package com.github.fritaly.leetcode;

public class SwapNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode result = null, previous = null;
		
		while ((head != null) && (head.next != null)) {
			ListNode first = head;
			ListNode second = head.next;
			ListNode third = head.next.next;
			
			first.next = third;
			second.next = first;
			
			if (previous != null) {
				previous.next = second;
			}
			
			previous = first;
			
			if (result == null) {
				result = second;
			}
			
			head = third;
		}
		
		return (result == null) ? head : result;
	}
}