package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
        	return head;
        ListNode parent = null, cur = head, iterator = head;
        int count = 0;
        while (iterator != null) {
        	if (count == n) {
        		parent = cur;
        		cur = cur.next;
        		iterator = iterator.next;
        	} else {
        		iterator = iterator.next;
        		count++;
        	}
        }
        if (parent != null) {
        	parent.next = cur.next;
        	return head;
        } else {
        	return head.next;
        }
    }
}
