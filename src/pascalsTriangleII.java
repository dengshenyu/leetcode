package test.test;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] rows = new Integer[rowIndex + 1];
        rows[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
        	for (int j = i; j >= 0; j--) {
        		if (j == 0 || j == i)
        			rows[j] = 1;
        		else 
        			rows[j] = rows[j] + rows[j-1];
        	}
        }
        return Arrays.asList(rows);
    }

}
