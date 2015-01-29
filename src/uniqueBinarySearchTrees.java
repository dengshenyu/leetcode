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
	int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= i; j++)
        		dp[i] += dp[j-1] * dp[i - j];
        }
        return dp[n];
    }
}


