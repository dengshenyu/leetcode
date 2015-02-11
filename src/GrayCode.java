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
    public List<Integer> grayCode(int n) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if (n == 0) {
    		result.add(0);
    		return result;
    	}
    	boolean[] bits = new boolean[n];
    	int k = 0;
    	boolean isStepOne = true;
    	while (true) {
    		result.add(k);
    		if (isStepOne) {
    			if (bits[n-1])
    				k -= 1;
    			else
    				k += 1;
    			bits[n-1] = !bits[n-1];
    		} else {
    			int i;
    			for (i = n-1; i >= 0; i--)
    				if (bits[i])
    					break;
    			if (i == 0)
    				break;
    			if (bits[i-1])
    				k -= (int)Math.pow(2, n - i);
    			else
    				k += (int)Math.pow(2, n - i);
    			bits[i-1] = !bits[i-1];
    		}
    		isStepOne = !isStepOne;
    	}
    	return result;
    }
}
