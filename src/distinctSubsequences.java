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
	int[][] dp;
	String s, t;
    public int numDistinct(String S, String T) {
    	if (T.length() == 0)
    		return 1;
    	else if (S.length() == 0)
    		return 0;
        dp = new int[S.length()+1][T.length()+1];
        s = S;
        t = T;
        //return numDistinct(0, 0);
        for (int i = 0; i <= s.length(); i++)
        	dp[i][t.length()] = 1;
        for (int i = t.length() - 1; i >= 0; i--) {
        	for (int j = s.length() - 1; j >= 0; j--) {
        		dp[j][i] = dp[j+1][i];
        		if (s.charAt(j) == t.charAt(i))
        			dp[j][i] += dp[j+1][i+1];
        	}
        }
        return dp[0][0];
    }
}


