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
    public int sqrt(int x) {
    	int end = search(0, 100000, x);
    	long t1 = (long)end * (long)end;
    	if (t1 == x)
    		return end;
    	else
    		return end-1;
    }
    private int search(int left, int right, long target) {
    	if (right - left <= 1)
    		return right;
    	int middle = (left + right) / 2;
    	long pivot = (long)middle * (long)middle;
    	if (pivot == target)
    		return middle;
    	else if (pivot < target)
    		return search(middle, right, target);
    	else
    		return search(left, middle, target);
    }
}
