package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix.length == 0)
    		return 0;
    	int result = 0;
        int[][][] ones = new int[matrix[0].length + 1][matrix.length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
        	for (int j = 0; j < matrix.length; j++) {
        		boolean isAllOnes = true;
        		for (int k = j; k < matrix.length; k++) {
        			if (matrix[k][i] == '1' && isAllOnes) {
        				ones[i+1][j][k] = ones[i][j][k] + 1;
        			} else
        				isAllOnes = false;
        			
    				if (ones[i+1][j][k] * (k - j + 1) > result)
    					result = ones[i+1][j][k] * (k - j + 1);
        		}
        	}
        }
        return result;
    }
}
