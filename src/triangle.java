package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        int uLeft = 0;
        dp[0] = triangle.get(0).get(0);
        for (List<Integer> row : triangle) {
        	int size = row.size();
        	if (size == 1)
        		dp[0] = row.get(0);
        	else {
        		int inRowIndex = 0;
        		for (int d : row) {
        			int min = Integer.MAX_VALUE;
        			if (inRowIndex > 0)
        				min = uLeft + d;
        			if (inRowIndex < size - 1 && dp[inRowIndex] + d < min)
        				min = dp[inRowIndex] + d;
        			uLeft = dp[inRowIndex];
        			dp[inRowIndex] = min;
        			inRowIndex++;
        		}
        	}
        }
        int min = dp[0];
        for (int i = 0; i < dp.length; i++) {
        	if (dp[i] < min)
        		min = dp[i];
        }
        return min;
    }
}
