package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Solution {

}

class LRUCache {
	class ListNode {
		int val;
		ListNode pre, next;
		ListNode(int v){val = v;pre = null; next = null;}
	}
	
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    HashMap<Integer, ListNode> index = new HashMap<Integer, ListNode>();
    ListNode head, tail;
    int capacity, used;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        used = 0;
        head = null;
    }
    private void update(int key) {
    	ListNode visited = index.get(key);
    	if (head == visited)
    		head = visited.next;
    	if (tail == visited)
    		tail = visited.pre;
    	if (visited.pre != null) 
    		visited.pre.next = visited.next;
    	if (visited.next != null)
    		visited.next.pre = visited.pre;
    	visited.pre = null;
    	visited.next = null;
    	if (head != null) {
    		visited.next = head;
    		head.pre = visited;
    		head = visited;
    		if (tail == null)
    			tail = visited;
    	} else {
    		head = visited;
    		tail = visited;
    	}
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
        	update(key);
        	return cache.get(key);
        }
        else
        	return -1;
    }
    
    public void set(int key, int value) {
    	if (cache.containsKey(key)) {
    		update(key);
    		cache.put(key, value);
    		return;
    	}
    	cache.put(key, value);
    	ListNode newNode = new ListNode(key);
    	index.put(key, newNode);
    	if (head == null) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		newNode.next = head;
    		head.pre = newNode;
    		head = newNode;
    	}
    	
        if (used < capacity) { 
        	used++;
        } else {
        	cache.remove(tail.val);
        	index.remove(tail);
        	tail = tail.pre;
        	if (tail != null)
        		tail.next = null;
        	else 
        		head = null;
        }
    }
}
