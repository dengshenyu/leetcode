package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if (head == null)
    		return null;
        ListNode fast = head, slow = head;
        while (true) {
        	if (fast.next != null && fast.next.next != null)
        		fast = fast.next.next;
        	else
        		return null;
        	slow = slow.next;
        	if (slow == fast)
        		break;
        }
        fast = head;
        while (fast != slow) {
        	fast = fast.next;
        	slow = slow.next;
        }
        return fast;
    }
}
