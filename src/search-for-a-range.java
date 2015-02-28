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
    public int[] searchRange(int[] A, int target) {
        return searchRange(A, 0, A.length - 1, target);
    }
    private int[] searchRange(int[] A, int left , int right, int target) {
    	if (right < left)
    		return new int[]{-1, -1};
    	else if (right == left) {
    		if (A[right] == target)
    			return new int[]{right, right};
    		else
    			return new int[]{-1, -1};
    	} else if (right - left == 1) {
    		int start = -1, end = -1;
    		if (A[left] == target) {
    			start = left;
    			end = left;
    		}
    		if (A[right] == target) {
    			if (start == -1)
    				start = right;
    			end = right;
    		}
    		return new int[]{start, end};
    	} else {
    		int middle = (left + right) / 2;
    		if (A[middle] < target)
    			return searchRange(A, middle, right, target);
    		else if (A[middle] > target)
    			return searchRange(A, left, middle, target);
    		else {
    			int start = middle, end = middle;
    			if (A[left] == target)
    				start = left;
    			else {
        			int[] l = searchRange(A, left, middle - 1, target);
        			if (l[0] != -1)
        				start = l[0];
    			}
    			if (A[right] == target)
    				end = right;
    			else {
        			int[] r = searchRange(A, middle + 1, right, target);
        			if (r[1] != -1)
        				end = r[1];
    			}
    			return new int[]{start, end};
    		}
    	}
    }
}
