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
	 public String minWindow(String S, String T) {
	    	if (T.length() == 0)
	    		return "";
	    	HashSet<Character> tset = new HashSet<Character>();
	    	HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
	    	HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
	    	for (int i = 0; i < T.length(); i++) {
	    		tset.add(T.charAt(i));
	    		Integer v = tmap.get(T.charAt(i));
	    		if ( v == null)
	    			tmap.put(T.charAt(i), 1);
	    		else
	    			tmap.put(T.charAt(i), v+1);
	    	}
	    	int count = 0;
	        int left = 0, right = -1, min = -1, begin = -1, end = -1;
	        for (int i = 0; i < S.length(); i++) {
	        	if (tset.contains(S.charAt(i))) {
	        		Integer v = smap.get(S.charAt(i));
	        		if (v == null) {
	        			v = 1;
	        			smap.put(S.charAt(i), v);
	        		} else {
	        			v++;
	        			smap.put(S.charAt(i), v);
	        		}
	        		
	        		if (v - tmap.get(S.charAt(i)) >= 0) {
	        			if (v - tmap.get(S.charAt(i)) == 0)
	        				count++;
	        			int tmp = left;
	        			while (tmp <= i) {
	        				if (tset.contains(S.charAt(tmp))) {
	        					int tv = smap.get(S.charAt(tmp));
	        					if (tv - 1 >= tmap.get(S.charAt(tmp))) {
	        						smap.put(S.charAt(tmp), tv - 1);
	        						tmp++;
	        					} else
	        						break;
	        				} else
	        					tmp++;
	        			}
	        			left = tmp;
	        			if (count == tset.size()) {
	        				right = i;
	        				//System.out.println(left + "" + i);
	        				if (min == -1 || right - left + 1 < min) {
	        					//System.out.println(i);
	        					min = right - left + 1;
	        					begin = left;
	        					end = right;
	        				}
	        			}

	        		}
	        	}
	        }
	        if (min == -1)
	        	return "";
	        else
	        	return S.substring(begin, end+1);
	    }
}
