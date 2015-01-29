package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public int candy(int[] ratings) {
    	int result = 0;
    	LinkedList<Integer> mins = new LinkedList<Integer>();
    	for (int i = 0; i< ratings.length; i++) {
    		if ( i > 0 && ratings[i] < ratings[i-1] && 
    				(i == ratings.length - 1 || ratings[i] <= ratings[i+1]))
    			mins.add(i);
    		else if (i + 1 < ratings.length && ratings[i] < ratings[i+1] && 
    				(i == 0 || ratings[i] <= ratings[i-1]))
    			mins.add(i);
    	}
    	int[] candy = new int[ratings.length];
    	Arrays.fill(candy, 1);
    	while (!mins.isEmpty()) {
    		int min = mins.poll();
    		//System.out.println(min);
    		for (int i = min - 1; i >= 0; i--) {
    			if (ratings[i] > ratings[i+1])
    				candy[i] = (candy[i] > candy[i+1] +1) ? candy[i] : candy[i+1] + 1;
    			else
    				break;
    		}
    		for (int i = min + 1; i < ratings.length; i++) {
    			if (ratings[i] > ratings[i-1])
    				candy[i] = (candy[i] > candy[i-1] +1) ? candy[i] : candy[i-1] + 1;
    			else
    				break;
    		}
    	}
    	for (int i = 0; i < ratings.length; i++)
    		result += candy[i];
    	return result;
    }
}
