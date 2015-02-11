package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;




public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int[] subset = new int[num.length];
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        getSubset(num, 0, subset, 0, result);
        return result;
    }
    
    private void getSubset(int[] num, int pos, int[] subset, int count, List<List<Integer>> result) {
    	if (pos == num.length) {
    		//for (int i = 0; i < count; i++)
    			//System.out.print(subset[i] + " ");
    		//System.out.println(isNotDup(subset, count));
    		if (isNotDup(subset, count)) {
    			LinkedList<Integer> sub = new LinkedList<Integer>();
    			for (int i = 0; i < count; i++)
    				sub.add(subset[i]);
    			result.add(sub);
    		}
    	} else {
    		getSubset(num, pos+1, subset, count, result);
    		subset[count] = num[pos];
    		getSubset(num, pos+1, subset, count+1, result);
    	}
    }
    
    HashSet<Integer> dup = new HashSet<Integer>();
    
    private boolean isNotDup(int[] a, int count) {
    	int hash = 59;
    	for (int i = 0; i < count; i++)
    		hash = hash * 17 + a[i];

    	if (dup.contains(hash))
    		return false;
    	dup.add(hash);
    	return true;
    }
    
    public static void main(String[] args) {
    	new Solution().subsetsWithDup(new int[]{1, 2, 2, 3});
    }
}
