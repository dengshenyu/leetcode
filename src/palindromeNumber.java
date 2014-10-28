package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0)
    		return false;
    	long highPriority = 1;
    	int tmp = x;
    	while (tmp / highPriority != 0) {
    		highPriority *= 10;
    	}
    	highPriority /= 10;
    	long high, low;
    	while (x != 0) {
    		high = x / highPriority;
    		low = x % 10;
    		if (high != low)
    			return false;
    		x -= highPriority * high;
    		highPriority /= 100;
    		x /= 10;
    	}
        return true;
    }
}
