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
    public void sortColors(int[] A) {
        qsort(A, 0, A.length - 1);
    }
    private void qsort(int[] A, int left, int right) {
    	if (left >= right)
    		return;
    	int pivot = A[(left + right) / 2];
    	int i = left, j = right;
    	while (i <= j) {
    		while(i <= j && A[j] > pivot)
    			j--;
    		while(i <= j && A[i] < pivot)
    			i++;
    		if (i <= j) {
    			int tmp = A[i];
    			A[i] = A[j];
    			A[j] = tmp;
    			i++;
    			j--;
    		}
    	}
    	if (left < j)
    		qsort(A, left, j);
    	if (i < right)
    		qsort(A, i, right);
    }
}
