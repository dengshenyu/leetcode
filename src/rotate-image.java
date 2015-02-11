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
    public void rotate(int[][] matrix) {
        int i = 0;
        int n = matrix.length;
        while (i <= (n-1) / 2) {
        	for (int x = i, y = i; y < n - 1 - i; y++) {
        		int old = matrix[x][y];
        		matrix[x][y] = matrix[n-1-y][x];
        		int tx = n - 1 - y, ty = x;
        		matrix[tx][ty] = matrix[n-1-ty][tx];
        		int o = tx;
        		tx = n - 1 - ty;
        		ty = o;
        		matrix[tx][ty] = matrix[n-1-ty][tx];
        		matrix[n-1-ty][tx] = old;
        	}
        	i++;
        }
    }
}
