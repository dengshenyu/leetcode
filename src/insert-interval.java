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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> result = new LinkedList<Interval>();
        if (intervals.isEmpty()) {
        	result.add(newInterval);
        	return result;
        }
        for (Interval i : intervals) {
        	if (newInterval == null || i.end < newInterval.start) {
        		result.add(i);
        	} else if (newInterval == null || i.start > newInterval.end) {
        		if (newInterval != null) {
        			result.add(newInterval);
        			newInterval = null;
        		}
        		result.add(i);
        	} else if (newInterval != null && i.end >= newInterval.start && newInterval.end >= i.start) {
        		int end = (i.end > newInterval.end) ? i.end : newInterval.end;
        		int start = (i.start < newInterval.start) ? i.start : newInterval.start;
        		newInterval = new Interval(start, end);
        		//result.add(newInterval);
        	}
        }
        if (newInterval != null)
        	result.add(newInterval);
        return result;
    }
}
