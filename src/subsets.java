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
	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
	LinkedList<Integer> sub = new LinkedList<Integer>();
    public List<List<Integer>> subsets(int[] S) {
        qsort(S, 0, S.length - 1);
        findSubsets(S, 0);
        return result;
    }
    private void findSubsets(int[] S, int pos) {
    	if (pos == S.length) {
    		LinkedList<Integer> r = new LinkedList<Integer>();
    		for (Integer i : sub)
    			r.add(i);
    		result.add(r);
    	} else {
    		findSubsets(S, pos+1);
    		sub.add(S[pos]);
    		findSubsets(S, pos+1);
    		sub.pollLast();
    	}
    }
    private void qsort(int[] S, int left, int right) {
    	if (left >= right)
    		return;
    	int middle = (left + right) / 2;
    	int pivot = S[middle];
    	int i = left, j = right;
    	while (i <= j) {
    		while (i <= j &&  S[j] > pivot)
    			j--;
    		while (i <= j && S[i] < pivot)
    			i++;
    		if (i <= j) {
    			int tmp = S[i];
    			S[i] = S[j];
    			S[j] = tmp;
    			i++;
    			j--;
    		}
    	}
    	if (j > left)
    		qsort(S, left, j);
    	if (i < right)
    		qsort(S, i, right);
    }
}
