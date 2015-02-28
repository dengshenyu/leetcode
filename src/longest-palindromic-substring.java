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
    public String longestPalindrome(String s) {
    	if (s.length() == 0)
    		return s;
        int distance = 0;
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
        	int m = i, n = i;
        	while ( m >= 0 && n < s.length()) {
        		if (s.charAt(m) == s.charAt(n)) {
        			m--;
        			n++;
        		} else
        			break;
        	}
        	m++;
        	n--;
        	if ( n - m + 1 > distance) {
        		distance = n - m + 1;
        		begin = m;
        		end = n;
        	}
        	
        	if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
        		m = i;
        		n = i + 1;
        		while ( m >= 0 && n < s.length()) {
            		if (s.charAt(m) == s.charAt(n)) {
            			m--;
            			n++;
            		} else
            			break;
            	}
            	m++;
            	n--;
            	if ( n - m + 1 > distance) {
            		distance = n - m + 1;
            		begin = m;
            		end = n;
            	}
        	}
        }
        return s.substring(begin, end+1);
    }
}
