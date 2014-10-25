package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
        HashSet<Integer> existVals = new HashSet<Integer>();
        ListNode parent = head, current = head.next;
        existVals.add(head.val);
        while (current != null) {
        	if (existVals.contains(current.val)) {
        		parent.next = current.next;
        	} else {
        		parent = current;
        		existVals.add(current.val);
        	}
        	current = current.next;
        }
        return head;
    }
}
