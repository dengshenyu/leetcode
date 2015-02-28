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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null)
        	return null;
        else if (lists.size() == 0)
        	return null;
        else if (lists.size() == 1)
        	return lists.get(0);
        ListNode[] arr = new ListNode[lists.size()];
        int i = 0;
        for (ListNode l : lists)
        	arr[i++] = l;
        return mergeKLists(arr, 0, arr.length - 1);
    }
    private ListNode mergeKLists(ListNode[] arr, int left, int right) {
    	if (right == left)
    		return arr[left];
    	else if (right - left == 1) {
    		return merge(arr[left], arr[right]);
    	}
    	int middle = (left + right) / 2;
    	ListNode leftList = mergeKLists(arr, left, middle - 1);
    	ListNode rightList = mergeKLists(arr, middle, right);
    	return merge(leftList, rightList);
    }
    private ListNode merge(ListNode a, ListNode b) {
    	if (a == null)
    		return b;
    	else if (b == null)
    		return a;
    	ListNode ita = a, itb = b, pre = null, next = null;
    	while (ita != null && itb != null) {
    		if (ita.val < itb.val) {
    			next = ita.next;
    			ita.next = itb;
    			if (pre == null) {
    				pre = ita;
    			} else {
    				pre.next = ita;
    				pre = ita;
    			}
    			ita = next;
    		} else {
    			next = itb.next;
    			itb.next = ita;
    			if (pre == null) {
    				pre = itb;
    			} else {
    				pre.next = itb;
    				pre = itb;
    			}
    			itb = next;
    		}
    	}
    	if (a.val < b.val)
    		return a;
    	else
    		return b;
    }
}
