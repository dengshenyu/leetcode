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
    public int searchInsert(int[] A, int target) {
    	if (A.length == 0)
    		return 0;
        return searchInsert(A, 0, A.length - 1, target);
    }
    private int searchInsert(int[] A, int left, int right, int target){
    	if (target <= A[left])
    		return left;
    	else if (target == A[right])
    		return right;
    	else if (target > A[right])
    		return right+1;
    	if (right - left <= 1)
    		return right;
    	int middle = (left + right) / 2;
    	if (A[middle] == target)
    		return middle;
    	else if (A[middle] > target)
    		return searchInsert(A, left, middle, target);
    	else
    		return searchInsert(A, middle, right, target);
    }
}
