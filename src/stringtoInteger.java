package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public int atoi(String str) {
        if (str == null)
        	return 0;
        int isValid = -1; //init
        int sign = -1;
        int begin = 0, end = str.length() - 1;
        long abs = 0;
        while (begin <= end && str.charAt(begin) == ' ')
        	begin++;
        while (begin <= end && str.charAt(end) == ' ')
        	end--;
        for (int i = begin; i <= end; i++) {
        	if (str.charAt(i) == '+') {
        		if (sign != -1) {
        			isValid = 0;
        			break;
        		}
        		sign = 1;
        	} else if (str.charAt(i) == '-') {
           		if (sign != -1) {
           			isValid = 0;
        			break;
           		}
        		sign = 2;
        		//System.out.println(isValid);
        	} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        		int cur = str.charAt(i) - '0';
        		if ((sign == 1 || sign == -1)) {
        			if (abs <= (Integer.MAX_VALUE - cur) / 10)
        				abs = abs * 10 + cur;
        			else
        				abs = Integer.MAX_VALUE;
        			if (isValid == -1)
        				isValid = 1;
        		} else if (sign == 2) {
        			if (abs <= (Integer.MIN_VALUE * (long)-1 - cur) / 10)
        				abs = abs * 10 + cur;
        			else
        				abs = Integer.MIN_VALUE * (long)-1;
           			if (isValid == -1)
        				isValid = 1;
        		} else {
        			isValid = 0;
        	        //System.out.println(isValid);
        			break;
        		}
        	} else {
        		isValid = 0;
        		break;
        	}
        }

        if (sign == 1 || sign == -1)
        	return (int)abs;
        else
        	return (int)(-abs);
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().atoi("  -0012a42"));
    }
}
