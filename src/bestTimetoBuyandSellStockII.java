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
    	int profit = 0;
    	for (int i = 0; i < prices.length; i++) {
    		if (i+1 < prices.length && prices[i+1] > prices[i])
    			profit += prices[i+1] - prices[i];
    	}
    	return profit;
    }
}
