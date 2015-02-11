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
    public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        permute(num, 0 , result);
        return result;
    }
    private void permute(int[] num, int pos, LinkedList<List<Integer>> result) {
    	if (pos == num.length) {
    		LinkedList<Integer> sub = new LinkedList<Integer>();
    		for (int i : num)
    			sub.add(i);
    		result.add(sub);
    	} else {
    		HashSet<Integer> dup = new HashSet<Integer>();
        	for (int i = pos; i < num.length; i++) {
        		if (!dup.contains(num[i])) {
        			dup.add(num[i]);
            		int tmp = num[pos];
            		num[pos] = num[i];
            		num[i] = tmp;
            		permute(num, pos+1, result);
            		tmp = num[pos];
            		num[pos] = num[i];
            		num[i] = tmp;
        		}

        	}
    	}
    }

    public static void main(String[] args) {
    	new Solution().permuteUnique(new int[]{1, 1, 2});
    }
}
