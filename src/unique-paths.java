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
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        //path[m-1][n-1] = 1;
        for (int i = m - 1; i >= 0; i--) {
        	for (int j = n - 1; j >= 0; j--) {
        		int s = 0;
        		if (j < n - 1)
        			s += path[i][j+1];
        		if (i < m - 1)
        			s += path[i+1][j];
        		if (s > 0)
        			path[i][j] = s;
        		else
        			path[i][j] = 1;
        	}
        }
        return path[0][0];
    }
}
