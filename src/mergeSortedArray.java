package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(){left = null; right = null;}
}


public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	if (n == 0)
    		return;
    	for (int i = m - 1; i >= 0; i--) {
    		A[i + n] = A[i];
    	}
    	int aIterator = 1, bIterator = 1;
    	int aPos = n, bPos = 0;
    	boolean smallFirst = true;
    	if (n >= 2 && m >= 2) {
    		if (A[0] > A[1]) {
    			smallFirst = false;
    			if (B[0] < B[1]) {
    				bIterator = -1;
    				bPos = n -1;
    			}
    		} else {
    			smallFirst =true;
    			if (B[0] > B[1]) {
    				bIterator = -1;
    				bPos = n - 1;
    			}
    		}
    	}
    	int curVal;
    	for (int i = 0; i < m + n; i++) {
    		if (aPos > m + n -1) {
    			curVal = B[bPos];
    			bPos += bIterator;
    		} else if (bPos < 0 || bPos > n -1) {
    			curVal = A[aPos];
    			aPos += aIterator;
    		} else {
    			if ((smallFirst && A[aPos] < B[bPos]) || (!smallFirst && A[aPos] > B[bPos])) {
					curVal = A[aPos];
					aPos += aIterator;
    			} else {
					curVal = B[bPos];
					bPos += bIterator;
    			}
    		}
    		A[i] = curVal;
    	}
    }
}
