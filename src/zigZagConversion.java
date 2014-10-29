package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public String convert(String s, int nRows) {
    	StringBuilder result = new StringBuilder();
    	int maxIndex = s.length() - 1;
    	int middleDis = 2 * nRows - 2;
    	for (int i = 0; i < nRows; i++) {
    		int j = i;
    		while (j <= maxIndex) {
    			result.append(s.charAt(j));
    			if (i != 0 && (i != nRows - 1) && middleDis > 0 && middleDis <= 2 * nRows - 4) {
    				int mIndex = j + middleDis;
    				if (mIndex <= maxIndex)
    					result.append(s.charAt(mIndex));
    			}
    			if (nRows > 1)
    				j += 2 * nRows - 2;
    			else
    				j += 1;
    		}
    		middleDis -= 2;
    	}
    	return result.toString();
    }
}
