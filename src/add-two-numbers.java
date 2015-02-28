package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	else if (l2 == null)
    		return l1;
    	
        ListNode head = null, tail = null;
        int inc = 0;
        while (l1 != null || l2 != null) {
        	int d = inc;
        	if (l1 != null) {
        		d += l1.val;
        		l1 = l1.next;
        	}

        	if (l2 != null) {
        		d += l2.val;
        		l2 = l2.next;
        	}

        	if (d >= 10) {
        		inc = 1;
        		d -= 10;
        	} else
        		inc = 0;
        	ListNode newNode = new ListNode(d);
        	if (head == null) {
        		head = newNode;
        		tail = newNode;
        	} else {
        		tail.next = newNode;
        		tail = newNode;
        	}
        }
        if (inc != 0) {
        	ListNode newNode = new ListNode(1);
        	tail.next = newNode;
        }
        return head;
    }
}
