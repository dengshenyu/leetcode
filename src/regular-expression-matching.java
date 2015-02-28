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
	int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[s.length()+1][p.length()+1];
        return isMatch(s, 0, p , 0);
    }
    private boolean isMatch(String s, int sPos, String p, int pPos) {
    	if (dp[sPos][pPos] != 0)
    		return dp[sPos][pPos] == 1;
    	if (sPos == s.length() && pPos == p.length())
    		return true;
    	else if (sPos == s.length() && pPos < p.length()) {
    		if (pPos+1 < p.length() && p.charAt(pPos+1) == '*' && isMatch(s, sPos, p, pPos+2))
    			dp[sPos][pPos] = 1;
    		else
    			dp[sPos][pPos] = -1;
    		return dp[sPos][pPos] == 1;
    	} else if (sPos < s.length() && pPos == p.length())
    		return false;
    	
    	if (p.charAt(pPos) == '.' || s.charAt(sPos) == p.charAt(pPos)) {
    		if (pPos+1 < p.length() && p.charAt(pPos+1) == '*') {
    			if (isMatch(s, sPos+1, p, pPos) || isMatch(s, sPos+1, p, pPos+2) || isMatch(s, sPos, p, pPos+2))
    				dp[sPos][pPos] = 1;
    			else
    				dp[sPos][pPos] = -1;
    		} else {
    			if (isMatch(s, sPos+1, p, pPos+1))
    				dp[sPos][pPos] = 1;
    			else
    				dp[sPos][pPos] = -1;
    		}
    	} else {
    		if (pPos+1 < p.length() && p.charAt(pPos+1) == '*' && isMatch(s, sPos, p, pPos+2)) {
    			dp[sPos][pPos] = 1;
    		} else
    			dp[sPos][pPos] = -1;
    	}
    	return dp[sPos][pPos] == 1;
    }
}
