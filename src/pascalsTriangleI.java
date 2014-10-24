package test.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int rowIndex) {
    	if (rowIndex == 0)
    		return new LinkedList<List<Integer>>();
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Integer[] rows = new Integer[]{1};
        result.add(Arrays.asList(rows));
        for (int i = 2; i <= rowIndex; i++) {
        	Integer[] curRows = new Integer[i];
        	for (int j = 0; j < i; j++) {
        		if (j == 0 || j == i -1) 
        			curRows[j] = 1;
        		else
        			curRows[j] = rows[j] + rows[j-1];
        	}
        	result.add(Arrays.asList(curRows));
        	rows = curRows;
        }
        return result;
    }
}
