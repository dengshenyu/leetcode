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
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null)
    		return;
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
        	len++;
        	tmp = tmp.next;
        }
        int middle = len / 2 + 1;
        int index = 1;
        tmp = head;
        while (index != middle) {
        	tmp = tmp.next;
        	index++;
        }
        ListNode right = tmp.next;
        tmp.next = null;
        //merge(head, right);
        LinkedList<ListNode> rightStack = new LinkedList<ListNode>();
        while (right != null) {
        	rightStack.addFirst(right);
        	right = right.next;
        }
        ListNode left = head, next;
        while (!rightStack.isEmpty()) {
        	ListNode cur = rightStack.poll();
        	next = left.next;
        	left.next = cur;
        	cur.next = next;
        	left = next;
        }
    }
}
