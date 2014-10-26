package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int lengthOfLastWord(String s) {
    	if (s == null || s.isEmpty())
    		return 0;
    	int end = -1;
    	int result = 0;
    	for(int i = s.length() - 1; i >= 0; i--) {
    		if (s.charAt(i) != ' ') {
    			if (end == -1)
    				end = i;
    		} else {
    			if (end != -1) {
    				return (end - i);
    			}
    		}
    	}
    	if (end != -1)
    		return (end + 1);
    	else
    		return 0;
    }
}
