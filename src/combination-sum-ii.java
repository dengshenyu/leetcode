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
	class Node {
		List<Integer> list;
		int hash;
		Node(List<Integer> l, int h){list = l; hash = h;}
	}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        HashSet<Integer> dup = new HashSet();
        for (int i = 0; i < candidates.length; i++) {
        	for (Node n : combinationSum(candidates, i, target)) {
        		if (!dup.contains(n.hash)) {
        			dup.add(n.hash);
        			result.add(n.list);
        		}
        	}

        }
        return result;
    }
    private List<Node> combinationSum(int[] candidates, int pos, int target) {
    	LinkedList<Node> result = new LinkedList<Node>();
    	if (pos == candidates.length)
    		return result;
		if (candidates[pos] > target)
			return result;
		else if (candidates[pos] == target) {
			LinkedList<Integer> sub = new LinkedList<Integer>();
			sub.add(candidates[pos]);
			Node n = new Node(sub, 23 * candidates[pos] + 59);
			result.add(n);
			return result;
		} else {
			HashSet<Integer> dup = new HashSet<Integer>();
			for (int i = pos + 1; i < candidates.length; i++) {
				List<Node> sub = combinationSum(candidates, i, target - candidates[pos]);
				if (!sub.isEmpty()) {
					Iterator<Node> it = sub.iterator();
					while (it.hasNext()) {
						Node n = it.next();
						if (!dup.contains(n.hash)) {
							dup.add(n.hash);
							LinkedList<Integer> l = (LinkedList<Integer>)n.list;
							l.addFirst(candidates[pos]);
							n.hash = n.hash * candidates[pos] + 59;
							result.add(n);
						}
					}
				}
			}
			return result;
		}
    }
}
