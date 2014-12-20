package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	private HashMap<String, List<String>> dp = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> dict) {
    	if (dp.containsKey(s))
    		return dp.get(s);
        LinkedList<String> result = new LinkedList<String>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	String subString = s.substring(0, i + 1);
        	if (dict.contains(subString)) {
        		if (i == len - 1) {
        			result.add(subString);
        		} else {
        			List<String> subResults = wordBreak(s.substring(i+1), dict);
        			if (!subResults.isEmpty()) {
        				for (String sen : subResults) {
        					result.add(subString + " " + sen);
        				}
        			}
        		}
        	}
        }
        dp.put(s, result);
        return result;
    }
}
