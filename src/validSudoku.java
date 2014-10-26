package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] n = new int[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(n, 0);
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			int tmp = board[i][j] - '0';
        			if (tmp < 1 || tmp > 9)
        				return false;
        			if (n[tmp] != 0)
        				return false;
        			n[tmp] = 1;
        		}
        	}
        }
        for (int i = 0; i < 9; i++) {
            Arrays.fill(n, 0);
        	for (int j = 0; j < 9; j++) {
        		if (board[j][i] != '.') {
        			int tmp = board[j][i] - '0';
        			if (tmp < 1 || tmp > 9)
        				return false;
        			if (n[tmp] != 0)
        				return false;
        			n[tmp] = 1;
        		}
        	}
        }
        for (int i = 0; i <= 6; i += 3) {
        	for(int j = 0; j <= 6; j += 3) {
        		Arrays.fill(n, 0);
        		for (int k = 0; k < 3; k++) {
        			for (int l = 0; l < 3; l++) {
        				if (board[i + k][j + l] != '.') {
        					int tmp = board[i + k][j + l] - '0';
        					if (tmp < 1 || tmp > 9)
                				return false;
                			if (n[tmp] != 0)
                				return false;
                			n[tmp] = 1;
        				}
        			}
        		}
        	}
        }
        return true;
    }
}
