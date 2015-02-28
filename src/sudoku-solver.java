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
    public void solveSudoku(char[][] board) {
    	dfs(board, 0, 0);
    }
    private boolean dfs(char[][] board, int x, int y) {
    	if (x == 9)
    		return true;
    	int nx = x + (y + 1) / 9;
    	int ny = (y + 1) % 9;
    	if (board[x][y] != '.')
    		return dfs(board, nx, ny);
    	else {
    		boolean[] dup = new boolean[10];
    		int ty = y - y % 3;
    		int tx = x - x % 3;
    		for (int i = 0; i < 9; i++) {
    			if (board[x][i] != '.')
    				dup[board[x][i] - '0'] = true;
    			if (board[i][y] != '.')
    				dup[board[i][y] - '0'] = true;
    			if (board[tx + i / 3][ty + i % 3] != '.')
    				dup[board[tx + i / 3][ty + i % 3] - '0'] = true;
    		}
    		for (int i = 1; i <= 9; i++) {
    			if (!dup[i]) {
    				board[x][y] = (char)('0' + i);
    				if (dfs(board, nx, ny))
    					return true;
    				board[x][y] = '.';
    			}
    		}
    		return false;
    	}
    }
    public static void main(String[] args) {
    	String[] s = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
    	char[][] a = new char[9][];
    	for (int i = 0; i < 9; i++)
    		a[i] = s[i].toCharArray();
    	new Solution().solveSudoku(a);
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(a[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
