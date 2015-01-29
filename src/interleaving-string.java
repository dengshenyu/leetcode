package leetcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Solution {
	short[][][] dp;
	int max1, max2, max3;
	String s1, s2, s3;
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1.isEmpty())
    		return s2.equals(s3);
    	else if (s2.isEmpty())
    		return s1.equals(s3);
    	else if (s3.isEmpty())
    		return false;
        dp = new short[s1.length()][s2.length()][s3.length()];
        max1 = s1.length() - 1;
        max2 = s2.length() - 1;
        max3 = s3.length() - 1;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return isInterleave(0, 0, 0);
    }
    private boolean isInterleave(int l1, int l2, int l3) {
        if (l1 > max1 && l2 > max2 && l3 > max3)
            return true;
    	if (dp[l1][l2][l3] != 0)
    		return dp[l1][l2][l3] > 0;
    	if (max1 - l1 + 1 + max2 -l2 + 1 != max3 - l3 + 1)
    		return false;
    	if (l1 <= max1 && s1.charAt(l1) == s3.charAt(l3) && isInterleave(l1+1, l2, l3 + 1)) {
    		dp[l1][l2][l3] = 1;
    		return true;
    	}
    	if (l2 <= max2 && s2.charAt(l2) == s3.charAt(l3) && isInterleave(l1, l2+1, l3 + 1)){
    		dp[l1][l2][l3] = 1;
    		return true;
    	}
    	dp[l1][l2][l3] = -1;
    	return false;
    }
}


