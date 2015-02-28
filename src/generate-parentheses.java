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
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<String>();
        if (n == 0)
        	return result;
        char[] str = new char[n * 2];
        generateParenthesis(str, 0, n, n, result);
        return result;
    }
    private void generateParenthesis(char[] str, int pos, int left, int right, LinkedList<String> result) {
    	if (left == 0 && right == 0) {
    		result.add(new String(str));
    		return;
    	}
    	if (left == 0) {
    		str[pos] = ')';
    		generateParenthesis(str, pos+1, left, right - 1, result);
    	} else {
    		if (left == right) {
    			str[pos] = '(';
    			generateParenthesis(str, pos+1, left - 1, right, result);
    		} else {
    			str[pos] = '(';
    			generateParenthesis(str, pos+1, left - 1, right, result);
    			str[pos] = ')';
    			generateParenthesis(str, pos+1, left, right - 1, result);
    		}
    	}
    }
}
