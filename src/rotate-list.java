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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
        	return head;
        ListNode it = head;
        int nodes = 0;
        while (it != null) {
        	nodes++;
        	it = it.next;
        }
        n = n % nodes;
        if (n == 0)
        	return head;
        ListNode parent = null;
        it = head;
        int count = 0;
        while (it.next != null) {
        	count++;
        	if (count == n + 1) {
        		parent = head;
        	}
        	it = it.next;
        	if (parent != null)
        		parent = parent.next;
        }
        count++;
        if (count == n + 1)
        	parent = head;
        if (parent == null)
        	return head;
        it.next = head;
        head = parent.next;
        parent.next = null;
        return head;
    }
}
