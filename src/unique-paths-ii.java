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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
        	for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
        		if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
        			if (obstacleGrid[i][j] == 0)
        				path[i][j] = 1;
        		} else if (obstacleGrid[i][j] == 0) {
            		int s = 0;
            		if (j <  obstacleGrid[i].length - 1 && obstacleGrid[i][j+1] == 0)
            			s += path[i][j+1];
            		if (i < obstacleGrid.length - 1 && obstacleGrid[i+1][j] == 0)
            			s += path[i+1][j];
            		path[i][j] = s;
        		}
        		
        	}
        }
        return path[0][0];
    }
}
