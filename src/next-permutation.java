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
    public void nextPermutation(int[] num) {
        for (int i = num.length - 2; i >= 0; i--) {
        	if (num[i] < num[i+1]) {
        		int pos = search(num, i+1, num.length - 1, num[i]);
        		swap(num, pos, i);
        		if (i+1 < num.length)
        			Arrays.sort(num, i+1, num.length);
        		//for (int j = 0; j <)
        		return;
        	}
        }
        Arrays.sort(num);
    }
    private void swap(int[] num, int a, int b) {
    	int tmp = num[a];
    	num[a] = num[b];
    	num[b] = tmp;
    }
    private int search(int[] num, int left, int right, int target) {
    	if (right <= left)
    		return left;
    	else if (right - left == 1) {
    		if (num[right] > target)
    			return right;
    		else
    			return left;
    	}
    	else {
    		int middle = (left + right) / 2;
    		if (num[middle] <= target)
    			return search(num, left, middle, target);
    		else
    			return search(num, middle, right, target);
    	}
    }
}
