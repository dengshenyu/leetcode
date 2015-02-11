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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals == null || intervals.size() < 2)
    		return intervals;
    	LinkedList<Interval> result = new LinkedList<Interval>();
        Interval[] intervalsArr = new Interval[intervals.size()];
        int i = 0;
        for (Interval il : intervals)
        	intervalsArr[i++] = il;
        qsort(intervalsArr, 0, intervals.size() - 1);
        Interval pre = intervalsArr[0];
        for (i = 1; i < intervalsArr.length; i++) {
        	if (pre.end < intervalsArr[i].start) {
        		result.add(pre);
        		pre = intervalsArr[i];
        	} else {
        		int start = pre.start < intervalsArr[i].start ? pre.start : intervalsArr[i].start;
        		int end = pre.end > intervalsArr[i].end ? pre.end : intervalsArr[i].end;
        		pre = new Interval(start, end);
        	}
        }
        result.add(pre);
        return result;
    }
    private void qsort(Interval[] data, int left, int right) {
    	if (left >= right)
    		return;
    	int middle = (left + right) / 2;
    	Interval pivot = data[middle];
    	int i = left, j = right;
    	while (i <= j) {
    		while (i <= j && data[j].start > pivot.start)
    			j--;
    		while (i <= j && data[i].start < pivot.start)
    			i++;
    		if (i <= j) {
    			Interval tmp = data[j];
    			data[j] = data[i];
    			data[i] = tmp;
    			i++;
    			j--;
    		}
    	}
    	if (left < j)
    		qsort(data, left, j);
    	if (right > i)
    		qsort(data, i, right);
    }
}
