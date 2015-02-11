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
    public int[][] generateMatrix(int n) {
    	if (n == 0)
    		return new int[0][0];
        boolean[][] visited = new boolean[n][n];
        int[][] result = new int[n][n];
        int direction = 1;
        int k = 1;
        int x = 0, y = 0;
        int end = n * n;
        while (true) {
        	result[x][y] = k++;
        	if (k > end)
        		return result;
        	visited[x][y] = true;
        	switch(direction) {
        	case 1:
        		if (y + 1 < n && !visited[x][y+1]) {
        			y++;
        		} else {
        			direction = 2;
        			x++;
        		}
        		break;
        	case 2:
        		if (x + 1 < n && !visited[x+1][y]) {
        			x++;
        		} else {
        			direction = 3;
        			y--;
        		}
        		break;
        	case 3:
        		if (y - 1 >= 0 && !visited[x][y-1]) {
        			y--;
        		} else {
        			direction = 4;
        			x--;
        		}
        		break;
        	case 4:
        		if (x - 1 >= 0 && !visited[x-1][y]) {
        			x--;
        		} else {
        			direction = 1;
        			y++;
        		}
        		break;
        	}

        }
    }
}
