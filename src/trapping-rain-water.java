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


public class Solution {
	class Node {
		int height, len;
		Node(int h, int l){height = h; len = l;}
	}
    public int trap(int[] A) {
    	if (A.length == 0)
    		return 0;
    	ArrayList<Node> list = new ArrayList<Node>();
    	int result = 0;
    	int highest = 0;
    	list.add(new Node(A[0], 1));
    	for (int i = 1; i < A.length; i++) {
    		int last = list.size() - 1;
    		Node pre = list.get(last);
    		Node cur = new Node(A[i], 1);
    		if (pre.height > A[i]) {
    			list.add(cur);
    		} else if (pre.height == A[i]) {
    			pre.len += 1;
    		} else {
    			int preMax = list.get(highest).height;
    			if (list.get(highest).height <= pre.height) {
    				list.add(cur);
    				highest = i;
    			} else if (preMax > pre.height && preMax <= cur.height) {
    				int count = 0;
    				while (last != highest) {
    					Node tail = list.remove(last);
    					result += (preMax - tail.height) * tail.len;
    					count += tail.len;
    					last--;
    				}
    				if (preMax < cur.height) {
    					list.get(last).len += count;
    					list.add(cur);
    					highest = last + 1;
    				} else {
    					list.get(last).len += (count + 1);
    				}
    			} else {
    				while (list.get(last).height <= cur.height) {
    					result += (cur.height - list.get(last).height) * list.get(last).len;
    					cur.len += list.get(last).len;
    					last--;
    				}
    			}
    			
    		}
    	}
    	return result;
    }
}
