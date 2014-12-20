package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    public int maxPoints(Point[] points) {
    	if (points.length == 1)
    		return 1;
    	int result = 0;
        HashMap<Double, Integer>[] lines = new HashMap[points.length];
        int[] samePoints = new int[points.length];
        Arrays.fill(samePoints, 0);
        for (int i = 0; i < lines.length; i++)
        	lines[i] = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
        	for (int j = i + 1; j < points.length; j++) {
        		int x = points[j].x - points[i].x;
        		int y = points[j].y - points[i].y;
        		Double v = 0D;
        		if ( x != 0 ) {
            		v = (double)y / x;
        		} else if ( y != 0 )
        			v = Double.MAX_VALUE;
        		if ( x == 0 && y == 0) {
        			samePoints[i] = samePoints[i] + 1;
        			samePoints[j] = samePoints[j] + 1;
        		} else {
            		Integer pre = (Integer)lines[j].get(v);
            		if ( pre == null )
            			lines[j].put(v, 1);
            		else
            			lines[j].put(v, pre + 1);
        		}

        	}
        }
        for (int i = 0; i < points.length; i++) {
        	if (samePoints[i] + 1 > result)
        		result = samePoints[i] + 1;
        	Iterator<Entry<Double, Integer>> it = lines[i].entrySet().iterator();
        	while ( it.hasNext() ) {
        		Entry<Double, Integer>entry = it.next();
        		if ( entry.getValue() + 1 + samePoints[i] > result )
        			result = entry.getValue() + 1 + samePoints[i];
        	}
        }
        return result;
    }
}
