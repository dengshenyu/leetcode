package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        	return null;
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        newHead.next = null;
        map.put(head, newHead);
        RandomListNode oldIt = head, newIt = newHead;
        while (oldIt.next != null) {
        	newIt.next = new RandomListNode(oldIt.next.label);
        	newIt.next.next = null;
        	map.put(oldIt.next, newIt.next);
        	oldIt = oldIt.next;
        	newIt = newIt.next;
        }
        oldIt = head;
        newIt = newHead;
        while (oldIt != null) {
        	if (oldIt.random == null)
        		newIt.random = null;
        	else {
        		newIt.random = map.get(oldIt.random);
        	}
        	oldIt = oldIt.next;
        	newIt = newIt.next;
        }
        return newHead;
    }
}
