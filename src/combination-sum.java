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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
        	for (List<Integer> l : combinationSum(candidates, i, target))
        		result.add(l);
        }
        return result;
    }
    private List<List<Integer>> combinationSum(int[] candidates, int pos, int target) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (pos == candidates.length)
    		return result;
		if (candidates[pos] > target)
			return result;
		else if (candidates[pos] == target) {
			LinkedList<Integer> sub = new LinkedList<Integer>();
			sub.add(candidates[pos]);
			result.add(sub);
			return result;
		} else {
			for (int i = pos; i < candidates.length; i++) {
				List<List<Integer>> sub = combinationSum(candidates, i, target - candidates[pos]);
				if (!sub.isEmpty()) {
					Iterator<List<Integer>> it = sub.iterator();
					while (it.hasNext()) {
						LinkedList<Integer> l = (LinkedList<Integer>)it.next();
						l.addFirst(candidates[pos]);
						result.add(l);
					}
				}
			}
			return result;
		}
    }
}
