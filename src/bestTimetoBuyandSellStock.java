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
    public int maxProfit(int[] prices) {
    	int min = Integer.MAX_VALUE;
    	int profit = 0;
    	for (int i = 0; i < prices.length; i++) {
    		if (prices[i] - min > profit)
    			profit = prices[i] - min;
    		if (prices[i] < min)
    			min = prices[i];
    	}
    	return profit;
    }
}
