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
	class Node{
		long v;
		long d;
		Node(long tv, long td){v = tv; d = td;} 
	}
    public int divide(int dividend, int divisor) {
        if (divisor == 0 )
        	return Integer.MAX_VALUE;
        else if (dividend == 0)
        	return 0;
        boolean positive = true;
        long dd = dividend;
        long dr = divisor;
        if (dd < 0) {
        	positive = !positive;
        	dd = -dd;
        }
        if (dr < 0) {
        	positive = !positive;
        	dr = -dr;
        }
        LinkedList<Node> list = new LinkedList<Node>();
        long j = 1;
        long i = dr;
        while (i <= dd) {
        	list.add(new Node(i, j));
        	i += i;
        	j += j;
        }
        long result = 0;
        while (!list.isEmpty()) {
        	Node tail = list.pollLast();
        	if (dd >= tail.v) {
        		dd -= tail.v;
        		result += tail.d;
        	}
        }
        if (positive) {
        	if (result > Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        	else
        		return (int)result;
        }
        else {
        	return (int)(-result);
        }

    }
}
