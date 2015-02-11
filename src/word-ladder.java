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
		String val;
		int pLen;
		public Node(String v) {val = v;}
	}
    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<Node> bfsQueue = new LinkedList<Node>();
        HashSet<String> visited = new HashSet<String>();
        Node head = new Node(start);
        head.pLen = 1;
        bfsQueue.add(head);
        visited.add(start);
        dict.add(end);
        while (!bfsQueue.isEmpty()) {
        	Node cur = bfsQueue.poll();
        	if (cur.val.equals(end))
        		return cur.pLen;
        	StringBuilder bd = new StringBuilder(cur.val);
        	for (int i = 0; i < cur.val.length(); i++) {
        		for (int j = 0; j < 26; j++) {
        			if ('a' + j != cur.val.charAt(i)) {
        				bd.setCharAt(i, (char)('a'+j));
        				String next = bd.toString();
        				if (!visited.contains(next) && dict.contains(next)) {
        					visited.add(next);
        					Node nextNode = new Node(next);
        					nextNode.pLen = cur.pLen + 1;
        					bfsQueue.add(nextNode);
        				}
        				bd.setCharAt(i, cur.val.charAt(i));
        			}
        		}
        	}
        }
        return 0;
    }
}
