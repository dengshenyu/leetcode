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
	public boolean isMatch(String s, String p) {
		int count = 0;
		for (int i = 0; i < p.length(); i++)
			if (p.charAt(i) != '*')
				count++;
		if (count > s.length())
			return false;
		int[][] dp = new int[s.length()][p.length()];
		return isMatch(s, p, s.length() - 1, p.length() - 1, dp);
	}
	public boolean isMatch(String s, String p, int ss, int pp, int[][] dp) {
		if (ss < 0) {
			int m;
			for (m = pp; m >= 0; m--) {
				if (p.charAt(m) != '*')
					break;
			}
			return m < 0;
		} else if (pp < 0)
			return false;
		else {
			if (dp[ss][pp] != 0)
				return dp[ss][pp] == 1;
			if (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(ss)) {
				dp[ss][pp] = isMatch(s, p, ss-1, pp-1, dp) ? 1 : -1;
				return dp[ss][pp] == 1;
			} else if (p.charAt(pp) == '*') {
				dp[ss][pp] = isMatch(s, p, ss-1, pp, dp) ? 1 : 0;
				if (dp[ss][pp] == 0)
					dp[ss][pp] = isMatch(s, p, ss, pp-1, dp) ? 1 : 0;
				if (dp[ss][pp] == 0)
					dp[ss][pp] = -1;
				return dp[ss][pp] == 1;
			} else {
				dp[ss][pp] = -1;
				return dp[ss][pp] == 1;
			}
		}
		//return true;
	}
	
    public static void main(String[] args) {
    	new Solution().isMatch("aaaaaaaaaaaaa*aaaaaaaaa*aaaa", "aaaaaaaaa*aaaaaaaaaaaaaaaaaaaaaa*");
    }
}
