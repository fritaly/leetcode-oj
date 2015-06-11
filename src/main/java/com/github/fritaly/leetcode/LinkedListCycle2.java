package com.github.fritaly.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public ListNode detectCycle(ListNode head) {
    	final Set<ListNode> visited = new HashSet<ListNode>();
    	
    	while (head != null) {
    		if (!visited.add(head)) {
    			return head;
    		}
    		
    		head = head.next;
    	}
    	
    	return null;
    }
}