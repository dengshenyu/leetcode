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
    	if (prices.length < 2)
    		return 0;
    	int[][][] profit = new int [2][3][prices.length];
    	for (int i = 0; i < 3; i++)
    		profit[1][i][prices.length-1] = prices[prices.length-1];
    	for (int i = prices.length-2; i >= 0; i--) {
    		profit[0][0][i] = profit[0][0][i+1];
    		profit[0][1][i] = (profit[1][0][i+1] - prices[i] > profit[0][1][i+1]) ? profit[1][0][i+1] - prices[i] : profit[0][1][i+1] ;
    		profit[0][2][i] = (profit[1][1][i+1] - prices[i] > profit[0][2][i+1]) ? profit[1][1][i+1] - prices[i] : profit[0][2][i+1];
    		profit[1][0][i] = (profit[1][0][i+1] > profit[0][0][i+1] + prices[i]) ? profit[1][0][i+1] : profit[0][0][i+1] + prices[i];
    		profit[1][1][i] = (profit[1][1][i+1] > profit[0][1][i+1] + prices[i]) ? profit[1][1][i+1] : profit[0][1][i+1] + prices[i];
    	}
    	return profit[0][2][0];
    }
}
