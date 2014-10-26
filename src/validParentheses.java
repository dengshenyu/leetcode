package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean isValid(String s) {
    	if (s == null)
    		return true;
    	LinkedList<String> stack = new LinkedList<String>();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
       			stack.push(String.valueOf(s.charAt(i)));
    		} else {
    			if (stack.isEmpty())
    				return false;
    			switch(s.charAt(i)) {
    			case ')':
    				if (!stack.peek().equals("("))
    					return false;
    				break;
    			case ']':
    				if (!stack.peek().equals("["))
    					return false;
    				break;
    			case '}':
    				if (!stack.peek().equals("{"))
    					return false;
    				break;
    			}
    			stack.poll();
    		}
    	}
    	
    	return stack.isEmpty();
    }
}
