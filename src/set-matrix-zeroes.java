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
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> columns = new HashSet<Integer>();
        for (int j = 0; j < matrix.length; j++)
        	rows.add(j);
        for (int j = 0; j < matrix[0].length; j++)
        	columns.add(j);
        int i = 0;
        while (i < matrix.length && columns.size() != 0) {
        	Iterator<Integer> it = columns.iterator();
        	while (it.hasNext()) {
        		Integer c = it.next();
        		if (matrix[i][c] == 0)
        			it.remove();
        	}
        	i++;
        }
        int j = 0;
        while (j < matrix[0].length && rows.size() != 0) {
        	Iterator<Integer> it = rows.iterator();
        	while (it.hasNext()) {
        		Integer r = it.next();
        		if (matrix[r][j] == 0)
        			it.remove();
        	}
        	j++;
        }
        for (i = 0; i < matrix.length; i++) {
        	if (!rows.contains(i)) {
        		for (j = 0; j < matrix[i].length; j++)
        			matrix[i][j] = 0;
        	}
        }
        for (j = 0; j < matrix[0].length; j++) {
        	if (!columns.contains(j)) {
        		for (i = 0; i < matrix.length; i++)
        			matrix[i][j] = 0;
        	}
        }
    }
}
