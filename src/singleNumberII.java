package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Solution {
    public int singleNumber(int[] A) {
    	qsort(A, 0, A.length - 1);
    	for (int i = 0; i < A.length; ) {
    		if (i + 2 >= A.length)
    			return A[i];
    		else if (A[i] != A[i+1] || A[i] != A[i+2])
    			return A[i];
    		i += 3;
    	}
    	return 0;
    }
    
    private void qsort(int[] a, int begin, int end) {
    	if (end <= begin)
    		return;
    	int c = a[begin];
    	int i = begin, j = end;
    	while (j > i) {
    		while (j > i && a[j] > c)
    			j--;
    		if (j > i) {
    			a[i++] = a[j];
    		}
    		while (j > i && a[i] <= c)
    			i++;
    		if (j > i) {
    			a[j--] = a[i];
    		}
    	}
    	a[i] = c;
    	qsort(a, begin, i-1);
    	qsort(a, i+1, end);
    }
}