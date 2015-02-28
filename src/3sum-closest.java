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

    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
    	int result = 0;
    	int distance = Integer.MAX_VALUE;
    	for (int i = 0; i < num.length; i++) {
    		for (int j = i + 1; j < num.length; j++) {
    			int sum = num[i] + num[j];
    			int third = target - sum;
    			if (third <= num[j] && j + 1 < num.length) {
    				int d = sum + num[j+1] - target;
    				if (d < 0)
    					d = -d;
    				if (d < distance) {
    					distance = d;
    					result = sum + num[j+1];
    				}
    			} else if ( j + 1 < num.length) {
    				int index = findClosest(num, j+1, num.length - 1, third);
    				int d = sum + num[index] - target;
    				if (d < 0)
    					d = -d;
    				if (d < distance) {
    					distance = d;
    					result = sum + num[index];
    				}
    				index++;
    				if (index < num.length) {
        				d = sum + num[index] - target;
        				if (d < 0)
        					d = -d;
        				if (d < distance) {
        					distance = d;
        					result = sum + num[index];
        				}
    				}
    			}
    		}
    	}
    	return result;
    }
    private int findClosest(int[] num, int left, int right, int target) {
    	if (target <= num[left])
    		return left;
    	else if (target >= num[right])
    		return right;
    	else if (right - left <= 1)
    		return left;
    	
    	int middle = (left + right) / 2;
    	if (num[middle] == target)
    		return middle;
    	else if (num[middle] > target)
    		return findClosest(num, left, middle, target);
    	else
    		return findClosest(num, middle, right, target);
    }
}
