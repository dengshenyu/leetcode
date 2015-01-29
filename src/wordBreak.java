package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
	HashMap<String, Boolean> dp = new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> dict) {
    	if (dp.containsKey(s))
    		return dp.get(s);
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	String subString = s.substring(0, i+1);
        	if (dict.contains(subString)) {
        		if (i == len - 1) {
        			dp.put(s, true);
        			return true;
        		} else if (wordBreak(s.substring(i+1), dict)) {
        			dp.put(s, true);
        			return true;	
        		}
        	}
        }
        dp.put(s, false);
        return false;
    }
}
