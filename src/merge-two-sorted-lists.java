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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	else if (l2 == null)
    		return l1;
        ListNode it1, it2, it;
        it1 = l1;
        it2 = l2;
        it = null;
        while(it1 != null && it2 != null) {
        	if (it1.val <= it2.val) {
        		if (it == null)
        			it = it1;
        		else {
        			it.next = it1;
        			it = it.next;
        		}
        		it1 = it1.next;
        	} else {
        		if (it == null)
        			it = it2;
        		else {
        			it.next = it2;
        			it = it.next;
        		}
        		it2 = it2.next;
        	}
        }
        it.next = (it1 == null) ? it2 : it1;
        return (l1.val <= l2.val) ? l1 : l2;
    }
}
