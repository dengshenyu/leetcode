package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 0, 4);
    }
    private LinkedList<String> restoreIpAddresses(String s, int start, int parts) {
    	LinkedList<String> result = new LinkedList<String>();
    	if (parts == 1) {
    		int len = s.length() - start;
    		if (start == s.length() || len > 3)
    			return result;
    		if (len == 1) 
    			result.add(s.substring(start));
    		else if (len == 2 && s.charAt(start) != '0')
    			result.add(s.substring(start));
    		else if (len == 3 && s.charAt(start) != '0' && Integer.parseInt(s.substring(start)) <= 255)
    			result.add(s.substring(start));
    		return result;
    	} else if (start == s.length())
    		return result;
    	int len = s.length() - start;
    	LinkedList<String> sub = restoreIpAddresses(s, start+1, parts-1);
    	for (String str : sub) {
    		result.add(s.charAt(start) + "." + str);
    	}
    	if (len >= 2 && s.charAt(start) != '0') {
    		sub = restoreIpAddresses(s, start+2 , parts-1);
        	for (String str : sub) {
        		result.add(s.substring(start, start+2) + "." + str);
        	}
    	}
    	if (len >= 3 && s.charAt(start) != '0' && Integer.parseInt(s.substring(start, start+3)) <= 255) {
    		sub = restoreIpAddresses(s, start+3 , parts-1);
        	for (String str : sub) {
        		result.add(s.substring(start, start+3) + "." + str);
        	}
    	}
    	return result;
    }
}


