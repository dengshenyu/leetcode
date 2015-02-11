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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
        	return null;
        ListNode cur = head;
        ListNode next = null, pre = null;
        while (cur != null && cur.next != null) {
        	next = cur.next;
        	while (next != null && next.val == cur.val)
        		next = next.next;
        	if (next != cur.next) {
        		if (pre == null) {
        			head = next;
        			cur = next;
        		} else {
        			pre.next = next;
        			cur = next;
        		}
        	} else {
        		pre = cur;
        		cur = next;
        	}
        }
        return head;
    }
}
