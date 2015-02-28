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
    public List<Integer> findSubstring(String S, String[] L) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if (L.length == 0)
    		return result;
    	int wl = L[0].length();
    	int m = L.length;
        for (int i = 0; i < wl; i++) {
        	HashMap<String, Integer> strs = new HashMap<String, Integer>();
        	int count = 0;
        	for (String s : L) {
        		Integer v = strs.get(s);
        		if (v == null) {
        			count++;
        			strs.put(s, 1);
        		} else
        			strs.put(s, v + 1);
        	}
        	int j = i;
        	int match = -1;
        	while (j < S.length()) {
        		if (j + wl - 1 < S.length()) {
        			String sub = S.substring(j, j + wl);
        			Integer v = strs.get(sub);
        			if (v != null) {
        				if (match == -1)
        					match = j;
        				if (v > 0) {
        					strs.put(sub, v - 1);
        					if (v - 1 == 0) {
        						count--;
        						if (count == 0) {
        							result.add(j - (m-1) * wl);
        						}
        					}
        					j += wl; //forward
        				} else {
        					String inc = S.substring(match, match + wl);
        					int c = strs.get(inc);
        					if ( c == 0)
        						count++;
        					strs.put(inc, c + 1);
        					match += wl;
        				}
        			} else {
        				match = -1;
        				j += wl;
        				count = 0;
        				strs = new HashMap<String, Integer>();
        	        	for (String s : L) {
        	        		Integer tmp = strs.get(s);
        	        		if (tmp == null) {
        	        			count++;
        	        			strs.put(s, 1);
        	        		} else
        	        			strs.put(s, tmp + 1);
        	        	}
        			}
        		} else
        			break;
        	}
        }
        return result;
    }
    public static void main(String[] args) {
    	List<Integer> l = new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
    	for (Integer i : l)
    		System.out.print(i + " ");
    }
}
