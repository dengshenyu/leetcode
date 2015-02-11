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
    public int minPathSum(int[][] grid) {
    	int[][] sum = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
        	for (int j = grid[i].length - 1; j >= 0; j--) {
        		int s = -1;
        		if (j < grid[i].length - 1)
        			s = grid[i][j] + sum[i][j+1];
        		if (i < grid.length - 1 && (s == -1 || sum[i+1][j] + grid[i][j] < s))
        			s = sum[i+1][j] + grid[i][j];
        		if (s != -1)
        			sum[i][j] = s;
        		else
        			sum[i][j] = grid[i][j];
        	}
        }
        return sum[0][0];
    }
}
