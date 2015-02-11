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

    public int largestRectangleArea(int[] height) {
    	if (height.length == 0)
    		return 0;
    	int result = 0;
    	LinkedList<Node> list = new LinkedList<Node>();
    	for (int i = 0 ; i < height.length; i++) {
    		if (height[i] > result)
    			result = height[i];
    		Node n = new Node(height[i], 1);
    		if (list.isEmpty() || list.peek().height < n.height) {
    			list.addFirst(n);
    		} else if (list.peek().height == n.height) {
    			n.len += list.peek().len;
    			list.poll();
    			list.addFirst(n);
    		} else {
    			Iterator<Node> it = list.iterator();
    			int tmpLen = 0;
    			while (it.hasNext()) {
    				Node cur = it.next();
    				if (cur.height > n.height) {
        				tmpLen += cur.len;
        				if (tmpLen * cur.height > result)
        					result = tmpLen * cur.height;
        				n.len += cur.len;
        				it.remove();
    				} else if (cur.height == n.height) {
    					n.len += cur.len;
    					it.remove();
    				} else {
    					break;
    				}
    			}
    			list.addFirst(n);
    		}
    		
    		//list.addFirst(n);
    	}
    	Iterator<Node> it = list.iterator();
		int tmpLen = 0;
		while (it.hasNext()) {
			Node cur = it.next();
			tmpLen += cur.len;
			if (tmpLen * cur.height > result)
				result = tmpLen * cur.height;
		}
    	return result;
    }
    
    public static void main(String[] args) {
    	new Solution().largestRectangleArea(new int[]{1,1,1,1,1,1});
    }
}
