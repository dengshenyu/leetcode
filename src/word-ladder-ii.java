package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
	class Node {
		int pLen;
		String val;
		Node next;
		public Node(String v){val = v; next = null; pLen = 0;}
	}
	LinkedList<String> path = new LinkedList<String>();
	LinkedList<List<String>> result = new LinkedList<List<String>>();
	HashMap<String, List<String>> neighbors = new HashMap<String, List<String>>();
	int min = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	LinkedList<String> bfsQueue = new LinkedList<String>();
    	bfsQueue.add(start);
    	HashSet<String> visited = new HashSet<String>();
    	visited.add(start);
    	while (!bfsQueue.isEmpty()) {
    		String cur = bfsQueue.poll();
    		StringBuilder bd = new StringBuilder(cur);
    		LinkedList<String> nList = new LinkedList<String>();
    		for (int i = 0; i < cur.length(); i++) {
    			for (int j = 0; j <= 25; j++) {
    				if (('a' + j) != cur.charAt(i)) {
    					bd.setCharAt(i, (char)('a'+j));
    					//String next = cur.substring(0, i) + (char)('a'+j) + cur.substring(i+1);
    					String next = bd.toString();
    					if (dict.contains(next)) {
    						nList.add(next);
    						if (!visited.contains(next)) {
    							visited.add(next);
    							bfsQueue.add(next);
    						}
    					}
    					bd.setCharAt(i, cur.charAt(i));
    				}
    			}
    		}
    		neighbors.put(cur, nList);
    	}
    	bfsFind(start, end);
    	return result;
    }
 
    private void bfsFind(String start, String end) {
    	LinkedList<Node> bfsQueue = new LinkedList<Node>();
    	HashMap<String, Integer> ladder = new HashMap<String, Integer>();
    	Node head = new Node(start);
    	head.pLen = 1;
    	bfsQueue.add(head);
    	boolean found = false;
    	ladder.put(start, 1);
    	
    	while (!bfsQueue.isEmpty()) {
    		Node cur = bfsQueue.poll();
    		if (cur.val.equals(end)) {
    			if (!found || cur.pLen <= result.peek().size()) {
    				LinkedList<String> r = new LinkedList<String>();
    				Node t = cur;
    				while (t != null) {
    					r.addFirst(t.val);
    					t = t.next;
    				}
    				result.add(r);
    			}
    			found = true;
    			
    		} else if(!found){
    			for (String s : neighbors.get(cur.val)) {
    				if (!ladder.containsKey(s) || (ladder.get(s) >= cur.pLen + 1)) {
    					Node nextNode = new Node(s);
    					nextNode.next = cur;
    					nextNode.pLen = cur.pLen + 1;
    					bfsQueue.add(nextNode);
    					ladder.put(s, nextNode.pLen);
    				}
    				
    			}
    		}
    	}
    }
}
