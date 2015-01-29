package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {

    public int longestConsecutive(int[] num) {
    	int[] pre = new int[num.length];
    	int[] next = new int[num.length];
    	HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer> ();
    	for (int i = 0; i < num.length; i++) {
    		pre[i] = i;
    		next[i] = i;
    		indexMap.put(num[i], i);
    		if (indexMap.containsKey(num[i]-1)){
    			int preIndex = indexMap.get(num[i]-1);
    			pre[i] = preIndex;
    			next[preIndex] = i;
    		}
    		if (indexMap.containsKey(num[i]+1)){
    			int nextIndex = indexMap.get(num[i]+1);
    			pre[nextIndex] = i;
    			next[i] = nextIndex;
    		}
    	}
    	int result = 0;
    	for (int i = 0; i < num.length; i++) {
    		if (pre[i] == i) {
    			int tmp = 0;
    			int j = i;
    			while (next[j] != j) {
    				j = next[j];
    				tmp++;
    			}
    			tmp++;
    			if (tmp > result)
    				result = tmp;
    		}
    	}
    	return result;
    }
}
