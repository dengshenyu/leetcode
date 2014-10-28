package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * I = 1	C = 100
 * V = 5	D = 500
 * X = 10	M = 1000
 * L = 50
 * 
 * */

public class Solution {
    public int romanToInt(String s) {
        String target = s.trim().toUpperCase();
        int cur, pre = 1;
        int result = 0;
        for (int i = target.length() - 1; i >= 0; i--) {
        	switch (target.charAt(i)) {
        	case 'I' :
        		cur = 1;
        		break;
        	case 'V' :
        		cur = 5;
        		break;
        	case 'X' :
        		cur = 10;
        		break;
        	case 'L' :
        		cur = 50;
        		break;
        	case 'C' :
        		cur = 100;
        		break;
        	case 'D' :
        		cur = 500;
        		break;
        	case 'M' :
        		cur = 1000;
        		break;
        	default :
        		return result;
        	}
        	if (cur >= pre)
        		result += cur;
        	else
        		result -= cur;
        	pre = cur;
        }
        return result;
    }
}
