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
    public int longestValidParentheses(String s) {
    	int result = 0;
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	boolean[] valid = new boolean[s.length()];
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(')
    			list.add(i);
    		else {
    			if (!list.isEmpty()) {
    				valid[list.pollLast()] = true;
    				valid[i] = true;
    			}
    		}
    	}
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (valid[i]) {
    			count++;
    			if (count > result)
    				result = count;
    		} else
    			count = 0;
    	}
    	return result;
    }
}
