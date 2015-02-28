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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode newHead = null, newTail = null;
        ListNode it = head, sec = null, next = null;
        while (it != null && it.next != null) {
        	sec = it.next;
        	next = it.next.next;
        	it.next = next;
        	sec.next = it;
        	if (newTail == null) {
        		newTail = it;
        		newHead = sec;
        	} else {
        		newTail.next = sec;
        		newTail = it;
        	}
        	it = next;
        }
        return newHead;
    }
}
