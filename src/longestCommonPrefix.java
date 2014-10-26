package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null)
    		return null;
    	else if (strs.length == 0)
    		return "";
        int pos = 0;
        while (true) {
        	for (int i = 0; i< strs.length; i++) {
        		if (pos >= strs[i].length()) {
        			if (strs[i].length() == 0)
        				return "";
        			else
        				return strs[i].substring(0, pos);
        		}
        		else if (i > 0 && strs[i].charAt(pos) != strs[i - 1].charAt(pos))
        			return strs[0].substring(0, pos);
        	}
        	pos++;
        }
    }
}
