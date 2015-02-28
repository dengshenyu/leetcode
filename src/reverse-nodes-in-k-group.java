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

	
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
        	return head;
        int count = 0;
        ListNode newHead = head, newTail = null;
        ListNode it = head;
        while (it != null) {
        	count++;
        	if (count == k) {
        		ListNode subHead = it;
        		it = it.next;
        		ListNode subTail;
        		if (newTail == null) {
        			subTail = head;
        		} else {
        			subTail = newTail.next;
        		}
        		ListNode pre = it, cur = subTail, next = null;
        		while (cur != subHead) {
        			next = cur.next;
        			cur.next = pre;
        			pre = cur;
        			cur = next;
        		}
        		cur.next = pre;
        		if (newTail == null) {
        			newTail = subTail;
        			newHead = subHead;
        		} else {
        			newTail.next = subHead;
        			newTail = subTail;
        		}
        		count = 0;
        	} else
        		it = it.next;
        }
        return newHead;
    }
}
