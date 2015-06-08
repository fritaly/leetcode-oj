package com.github.fritaly.leetcode;

public class RemoveLinkedListElements {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = null, result = null;
        
        while (head != null) {
        	if (head.val != val) {
        		if (current != null) {
        			current.next = head;
        		} else {
        			result = head;
        		}
        	
        		current = head;
        	} else {
        		if (current != null) {
        			current.next = null;
        		}
        	}
        
        	head = head.next;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	
		new RemoveLinkedListElements().removeElements(head, 2);
	}
}