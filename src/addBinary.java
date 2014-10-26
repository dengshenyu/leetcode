package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String addBinary(String a, String b) {
    	if (a.isEmpty() && b.isEmpty())
    		return "";
        int lenA = a.length();
        int lenB = b.length();
        char[] result;
        if (lenA > lenB)
        	result = new char[lenA + 1];
        else
        	result = new char[lenB + 1];
        int i = lenA - 1, j = lenB - 1;
        int plus = 0;
        int k = result.length - 1;
        while (i >= 0 || j >= 0) {
        	if (i >= 0) {
        		plus += (a.charAt(i) - '0');
        		i--;
        	}
        	if (j >= 0) {
        		plus += (b.charAt(j) - '0');
        		j--;
        	}
        	if (plus >= 2) {
        		result[k] = (char)('0' + (plus - 2));
        		plus = 1;
        	} else {
        		result[k] = (char)('0' + plus);
        		plus = 0;
        	}
        	k--;
        }
        if (plus == 1) {
        	result[k] = '1';
        	k--;
        }
        return String.valueOf(result, k + 1, result.length - (k + 1));
    }
}
