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
    public boolean exist(char[][] board, String word) {
    	if (word.length() == 0)
    		return true;
        isVisited = new boolean[board.length][board[0].length];
        maxX = board.length - 1;
        maxY = board[0].length - 1;
        for (int i = 0; i <= maxX; i++) {
        	for (int j = 0; j <= maxY; j++) {
        		if (board[i][j] == word.charAt(0) && exist(board, i, j, word, 0))
        			return true;
        	}
        }
        return false;
    }
    boolean[][] isVisited;
    int maxX,maxY;
    private boolean exist(char[][] board, int x, int y, String word, int pos) {
    	isVisited[x][y] = true;
    	if (pos+1 >= word.length())
    		return true;
    	if (x > 0 && !isVisited[x-1][y] && board[x-1][y] == word.charAt(pos+1) && exist(board, x-1, y, word, pos+1))
			return true;
		else if (x < maxX && !isVisited[x+1][y] && board[x+1][y] == word.charAt(pos+1) && exist(board, x+1, y, word, pos+1))
			return true;
		else if (y > 0 && !isVisited[x][y-1] && board[x][y-1] == word.charAt(pos+1) &&  exist(board, x, y-1, word, pos+1))
			return true;
		else if (y < maxY && !isVisited[x][y+1] && board[x][y+1] == word.charAt(pos+1) && exist(board, x, y+1, word, pos+1))
			return true;
    		
    	isVisited[x][y] = false;
    	return false;

    }
}
