package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;




public class Solution {
	int p[][];
    public List<List<String>> partition(String s) {
    	p = new int[s.length()][s.length()];
    	return partition(s, s.length() - 1);
    }
    public List<List<String>> partition(String s, int end) {
    	LinkedList<List<String>> results = new LinkedList<List<String>>();

        if (end == 0) {
        	LinkedList<String> result = new LinkedList<String>();
        	result.add(s.substring(0, 1));
        	results.add(result);
        	return results;
        } else if (end < 0) {
        	LinkedList<String> result = new LinkedList<String>();
        	results.add(result);
        	return results;
        }
        for (int i = end; i >= 0; i--) {
        	if (isPalindrome(s, i, end)) {
        		List<List<String>> subs = partition(s, i - 1);
        		for (List<String> result : subs) {
        			result.add(s.substring(i, end+1));
        			results.add(result);
        		}
        	}
        }
        return results;
    }
    private boolean isPalindrome(String s, int begin, int end) {
    	if (begin >= end)
    		return true;
    	if (p[begin][end] != 0)
    		return p[begin][end] == 1;
    	if (s.charAt(begin) == s.charAt(end) && isPalindrome(s, begin+1, end-1)) {
    		p[begin][end] = 1;
    		return true;
    	} else {
    		p[begin][end] = -1;
    		return false;
    	}
    	
    }
}


