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
    public boolean searchMatrix(int[][] matrix, int target) {
        int end = searchInterval(matrix, 0, matrix.length - 1, target);
        if (end == -1)
        	return false;
        else if (matrix[end][matrix[end].length - 1] == target)
        	return true;
        else if (end > 0 && matrix[end-1][matrix[end-1].length - 1] == target)
        	return true;
        return search(matrix[end], 0, matrix[end].length - 1, target);
    }
    private boolean search(int[] a, int left, int right, int target) {
    	if (target < a[left] || target > a[right])
    		return false;
    	else if (right == left) 
    		return a[left] == target;
    	else if (right - left == 1)
    		return a[left] == target || a[right] == target;
    	int middle = (left + right) / 2;
    	if (a[middle] == target)
    		return true;
    	else if (a[middle] > target)
    		return search(a, left, middle, target);
    	else
    		return search(a, middle, right, target);
    }
    private int searchInterval(int[][] matrix, int left, int right, int target) {
    	if (target <= matrix[left][matrix[left].length - 1])
    		return left;
    	else if (target > matrix[right][matrix[right].length -1])
    		return -1;
    	else if (right - left <= 1)
    		return right;
    	int middle = (left + right) / 2;
    	if (matrix[middle][matrix[middle].length - 1] >= target)
    		return searchInterval(matrix, left, middle, target);
    	else
    		return searchInterval(matrix, middle, right, target);
    }
    public static void main(String[] args) {
    	new Solution().searchMatrix(new int[][]{{1,3}}, 2);
    }
}
