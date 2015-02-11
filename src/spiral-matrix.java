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
    public List<Integer> spiralOrder(int[][] matrix) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if (matrix.length == 0)
    		return result;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int d = 1;
        int x = 0, y = 0;
        int m = matrix.length, n = matrix[0].length;
        int end = m * n;
        while (true) {
        	result.add(matrix[x][y]);
        	end--;
        	if (end == 0)
        		return result;
        	visited[x][y] = true;
        	switch(d) {
        	case 1:
        		if (y + 1 < n && !visited[x][y+1]) {
        			y++;
        		} else {
        			d = 2;
        			x++;
        		}
        		break;
        	case 2:
        		if (x + 1 < m && !visited[x+1][y]) {
        			x++;
        		} else {
        			d = 3;
        			y--;
        		}
        		break;
        	case 3:
        		if (y - 1 >= 0 && !visited[x][y-1]) {
        			y--;
        		} else {
        			d = 4;
        			x--;
        		}
        		break;
        	case 4:
        		if (x - 1 >= 0 && !visited[x-1][y]) {
        			x--;
        		} else {
        			d = 1;
        			y++;
        		}
        		break;
        	}
        }
    }
}
