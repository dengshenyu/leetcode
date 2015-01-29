package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
        	return null;
        ListNode mNodeParent = null, mNode = null, it, parent = null, next = null;
        it = head;
        int count = 1;
        while (true) {
        	if (count == m - 1)
        		mNodeParent = it;
        	else if (count == m)
        		mNode = it;
        	
        	if (count < m) {
        		parent = it;
        		it = it.next;
        	} else {
        		next = it.next;
        		it.next = parent;
        		parent = it;
        		it = next;
        	}
        	
        	if (count == n) {
        		mNode.next = next;
        		if (mNodeParent != null)
        			mNodeParent.next = parent;
        		else
        			head = parent;
        		return head;
        	}
        	count++;
        }
    }
}


