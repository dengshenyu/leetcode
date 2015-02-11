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
    public List<List<Integer>> combine(int n, int k) {
        findSubs(n, 1, k, 0);
        return result;
    }
    private void findSubs(int n, int pos, int k, int cur) {
    	if (cur == k) {
    		LinkedList<Integer> r = new LinkedList<Integer>();
    		for (Integer i : sub)
    			r.add(i);
    		result.add(r);
    	} else {
    		if (pos > n)
    			return;
    		else if (n - pos + 1 < k - cur)
    			return;
    		findSubs(n, pos+1, k, cur);
    		sub.add(pos);
    		findSubs(n, pos+1, k, cur+1);
    		sub.pollLast();
    	}
    }
}
