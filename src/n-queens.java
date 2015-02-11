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
	class Node {
		int x, y;
		Node(int tx, int ty){x = tx; y = ty;}
	}
	LinkedList<Node> queens = new LinkedList<Node>();
	LinkedList<String[]> result = new LinkedList<String[]>();
	char[][] board;
    public List<String[]> solveNQueens(int n) {
    	board = new char[n][n];
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < n; j++)
    			board[i][j] = '.';
    	solvedNQueens(n , 0);
    	return result;
    }
    private void solvedNQueens(int n, int row) {
    	if (row == n) {
    		String[] sub = new String[n];
    		for (int i = 0; i < n; i++) {
    			sub[i] = String.valueOf(board[i]);
    		}
    		result.add(sub);
    	} else {
    		for (int i = 0; i < n; i++) {
    			boolean can = true;
    			for (Node queen : queens) {
    				if (i == queen.y || (i - queen.y == row - queen.x) || (queen.y - i == row - queen.x)) {
    					can = false;
    					break;
    				}
    			}
    			if (can) {
    				board[row][i] = 'Q';
    				Node newQueen = new Node(row, i);
    				queens.add(newQueen);
    				solvedNQueens(n, row+1);
    				board[row][i] = '.';
    				queens.pollLast();
    			}
    		}
    	}
    }
}
