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
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 1) {
        	int median = ((A.length + B.length) / 2) + 1;
        	return findMedianSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, median, true);
        } else {
        	int m1 = (A.length + B.length) / 2;
        	double d1 = findMedianSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, m1, true);
        	//double d2 = 1;
        	double d2 = findMedianSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, m1+1, true);
        	return (d1 + d2) / 2;
        }
    }
    private int findMedianSortedArrays(int[] a, int la, int ra, int[] b, int lb, int rb, int median, boolean isATurn) {
    	
    	if (isATurn) {
    		if (ra < la) {
    			return findMedianSortedArrays(a, la, ra, b, lb, rb, median, false);
    		} else if (ra == la) {
    			int pos = search(b, lb, rb, a[la]);
    			if (pos + la + 1 == median)
    				return a[la];
    			else if (pos + la + 1 < median)
    				return findMedianSortedArrays(a, la+1, ra, b, pos, rb, median, false);
    			else
    				return findMedianSortedArrays(a, la, ra-1, b, lb, pos - 1, median, false);
    		} else {
    			int middle = (la + ra) / 2;
    			int pos = search(b, lb, rb, a[middle]);
    			if (pos + middle + 1 == median)
    				return a[middle];
    			else if (pos + middle + 1 < median)
    				return findMedianSortedArrays(a, middle + 1, ra, b, pos, rb, median, false);
    			else
    				return findMedianSortedArrays(a, la, middle-1, b, lb, pos - 1, median, false);
    		}
    	} else {
    		return findMedianSortedArrays(b, lb, rb, a, la, ra, median, true);
    	}
    }
    private int search(int[] data, int left, int right, int target) {
    	if (right < left)
    		return left;
    	else if (target < data[left])
    		return left;
    	else if (target >= data[right])
    		return right + 1;
    	else if (right - left == 1)
    		return right;
    	
    	int middle = (left + right) / 2;
    	if (data[middle] == target)
    		return middle + 1;
    	else if (data[middle] > target)
    		return search(data, left, middle, target);
    	else
    		return search(data, middle, right, target);
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}));
    }
}
