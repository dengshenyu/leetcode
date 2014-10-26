package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty())
        	return false;
        String target = s.trim();
        if (target.isEmpty())
        	return false;
        boolean sign = true, isValid = true;
        int e = -1;
        int point = 1;
        for (int i = 0; i < target.length(); i++) {
        	if (target.charAt(i) == '+' || target.charAt(i) == '-') {
        		if (!sign)
        			return false;
        		sign = false;
        		isValid = false;
        	} else if (target.charAt(i) >= '0' && target.charAt(i) <= '9') {
        		sign = false;
        		isValid = true;
        		if (e == -1)
        			e = 1;
        		if (point == -1)
        			point = 1;
        	} else if (target.charAt(i) == '.') {
        		if(point != 1)
        			return false;
        		point = 0;
        		if (!((i - 1 >= 0) && isNumeric(target.charAt(i - 1))))
        			isValid = false;
        		sign = false;
        	} else if (target.charAt(i) == 'e') {
        		if (e != 1)
        			return false;
        		sign = true;
        		point = 0;
        		isValid = false;
        		e = 0;
        	} else
        		return false;
        }
        return isValid;
    }
    
    private boolean isNumeric(char c) {
    	return (c >= '0' && c <= '9');
    }
}
