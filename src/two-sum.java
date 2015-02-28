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
	class Entry {
		int index, value;
		Entry(int i, int v){index = i; value = v;}
	}
    public int[] twoSum(int[] numbers, int target) {
        Entry[] entries = new Entry[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
        	entries[i] = new Entry(i+1, numbers[i]);
        }
        qsort(entries, 0, entries.length - 1);
        int[] result = new int[2];
        for (int i = 0; i < entries.length; i++) {
        	if (target - entries[i].value >= entries[i].value && i+1 < entries.length) {
        		int j = find(entries, i+1, entries.length - 1, target - entries[i].value);
        		if (j != -1) {
            		result[0] = entries[i].index;
            		result[1] = entries[j].index;
            		break;
        		}
        	}
        }
        if (result[0] > result[1]) {
        	int bak = result[0];
        	result[0] = result[1];
        	result[1] = bak;
        }
        return result;
    }
    private int find(Entry[] a, int left, int right, int target) {
    	if (target < a[left].value || target > a[right].value)
    		return -1;
    	if (right - left <= 1) {
    		if (a[right].value == target)
    			return right;
    		else if (a[left].value == target)
    			return left;
    		else
    			return -1;
    	}
    	int middle = (left + right) / 2;
    	if (a[middle].value == target)
    		return middle;
    	else if (a[middle].value > target)
    		return find(a, left, middle - 1, target);
    	else
    		return find(a, middle + 1, right, target);
    }
    private void qsort(Entry[] a, int left, int right) {
    	if (right == left)
    		return;
    	Entry pivot = a[(left + right) / 2];
    	int i = left, j = right;
    	while (i <= j) {
    		while (i <= j && a[i].value < pivot.value)
    			i++;
    		while (j >= i && a[j].value > pivot.value)
    			j--;
    		if (i <= j) {
    			Entry bak = a[i];
    			a[i] = a[j];
    			a[j] = bak;
    			i++;
    			j--;
    		}
    	}
    	if (left < j)
    		qsort(a, left, j);
    	if (i < right)
    		qsort(a, i, right);
    }
}
