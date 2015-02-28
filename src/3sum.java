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
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        HashSet<String> dup = new HashSet<String>();
        for (int i = 0; i < num.length; i++) {
        	for (int j = i + 1; j < num.length; j++) {
        		int third = 0 - num[i] - num[j];
        		if (third >= num[j] && j+1 < num.length && search(num, j+1, num.length - 1, third)) {
        			String hash = "" + num[i] + num[j] + third;
        			if (!dup.contains(hash)) {
        				dup.add(hash);
        				LinkedList<Integer> r = new LinkedList<Integer>();
        				r.add(num[i]);
        				r.add(num[j]);
        				r.add(third);
        				result.add(r);
        			}
        		}
        	}
        }
        return result;
    }
    private boolean search(int[] num, int left, int right, int target) {
    	if (right - left <= 1)
    		return num[left] == target || num[right] == target;
    	int middle = (left + right) / 2;
    	if (num[middle] == target)
    		return true;
    	else if (num[middle] > target)
    		return search(num, left, middle - 1, target);
    	else
    		return search(num, middle + 1, right, target);
    }
}
