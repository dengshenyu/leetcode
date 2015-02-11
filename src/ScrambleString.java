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
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
        	return false;
    	return isScramble(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
    }

    private boolean isScramble(String s1, int b1, int end1, String s2, int b2, int end2) {
    	if (b1 > end1 || b2 > end2)
    		return true;
    	if (end1 == b1) {
    		if (s1.charAt(b1) == s2.charAt(b2))
    			return true;
    		else
    			return false;
    	}
    	int i = b1, j = b2, k = end2;
    	boolean isFoundj = false, isFoundk = false;
    	long counti = 0, countj = 0, countk = 0;
    	while (i < end1) {
    		counti += s1.charAt(i);
    		if (!isFoundj) {
    			countj += s2.charAt(j);
    			if (counti == countj && isSameChars(s1, b1, i, s2, b2, j)) {
    				isFoundj = true;
    				if (isScramble(s1, b1, i, s2, b2, j) && isScramble(s1, i+1, end1, s2, j+1, end2))
    					return true;
    			}
    		}
    		if (!isFoundk) {
    			countk += s2.charAt(k);
    			if (counti == countk && isSameChars(s1, b1, i, s2, k, end2)) {
    				isFoundk = true;
    				if (isScramble(s1, b1, i, s2, k, end2) && isScramble(s1, i+1, end1, s2, b2, k-1))
    					return true;
    			}
    		}
    		i++;
    		j++;
    		k--;
    	}
    	return false;
    }
    private boolean isSameChars(String s1, int b1, int end1, String s2, int b2, int end2) {
    	HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    	int i = b1, j = b2;
    	while (i <= end1) {
    		if (!map1.containsKey(s1.charAt(i)))
    			map1.put(s1.charAt(i), 1);
    		else
    			map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
    		
    		if (!map2.containsKey(s2.charAt(j)))
    			map2.put(s2.charAt(j), 1);
    		else
    			map2.put(s2.charAt(j), map2.get(s2.charAt(j)) + 1);
    		i++;
    		j++;
    	}
    	for (Map.Entry<Character, Integer> entry1 : map1.entrySet()) {
    		if (!map2.containsKey(entry1.getKey()) || map2.get(entry1.getKey()) != entry1.getValue())
    			return false;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	System.out.println(new Solution().isScramble("ab", "ba"));
    }
}
