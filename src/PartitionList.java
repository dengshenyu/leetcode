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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
        	return null;
        ListNode less = null, greater = null, lessTail = null, greaterTail = null;
        ListNode it = head;
        while (it != null) {
        	if (it.val < x) {
        		if (lessTail == null) {
        			less = new ListNode(it.val);
        			lessTail = less;
        		} else {
        			lessTail.next = new ListNode(it.val);
        			lessTail = lessTail.next;
        		}
        	} else {
        		if (greaterTail == null) {
        			greater = new ListNode(it.val);
        			greaterTail = greater;
        		} else {
        			greaterTail.next = new ListNode(it.val);
        			greaterTail = greaterTail.next;
        		}
        	}
        	it = it.next;
        }
        
        if (less != null) {
        	lessTail.next = greater;
        	return less;
        } else {
        	return greater;
        }
    }
}
