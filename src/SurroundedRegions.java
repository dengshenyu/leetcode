package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;



public class Solution {
	class Position {
		int x, y;
		public Position(int i, int j){
			x = i;
			y = j;
		}
	}
	private boolean[][] visited;
	private char[][] b;
    public void solve(char[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0)
    		return;
    	b = board;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
        		if (board[i][j] == 'O' && !visited[i][j]) {
        			LinkedList<Position> list = new LinkedList<Position>();
        			if (visit(i, j, list)) {
        				for (Position p : list) {
        					board[p.x][p.y] = 'X';
        				}
        			}
        		}
        	}
        }
    }
    private boolean visit(int x, int y, List<Position>list) {
    	boolean isSurrounded = true;
    	visited[x][y] = true;
    	LinkedList<Position> bfsQueue = new LinkedList<Position>();
    	bfsQueue.add(new Position(x, y));
    	while (!bfsQueue.isEmpty()) {
    		Position p = bfsQueue.poll();
    		list.add(p);
    		if (p.x == 0 || p.y == 0 || p.x == b.length - 1 || p.y == b[0].length - 1)
    			isSurrounded = false;
    		if (p.x - 1 >= 0 && b[p.x-1][p.y] == 'O' && !visited[p.x-1][p.y]) {
    			visited[p.x-1][p.y] = true;
    			bfsQueue.add(new Position(p.x-1, p.y));
    		}
    		if (p.x + 1 < b.length && b[p.x+1][p.y] == 'O' && !visited[p.x+1][p.y]) {
    			visited[p.x+1][p.y] = true;
    			bfsQueue.add(new Position(p.x+1, p.y));
    		}
    		if (p.y - 1 >= 0 && b[p.x][p.y-1] == 'O' && !visited[p.x][p.y-1]) {
    			visited[p.x][p.y-1] = true;
    			bfsQueue.add(new Position(p.x, p.y-1));
    		}
    		if (p.y + 1 < b[0].length && b[p.x][p.y+1] == 'O' && !visited[p.x][p.y+1]) {
    			visited[p.x][p.y+1] = true;
    			bfsQueue.add(new Position(p.x, p.y+1));
    		}
    	}
    	return isSurrounded;
    }
}
