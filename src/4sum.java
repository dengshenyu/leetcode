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
	class Entry {
		int first, second;
		Entry(int f, int s){first = f; second = s;}
	}
	HashSet<String> dup = new HashSet<String>();
    public List<List<Integer>> fourSum(int[] num, int target) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (num.length < 4)
    		return result;
    	Arrays.sort(num);
    	HashMap<Integer, ArrayList<Entry>> doubles = new HashMap<Integer, ArrayList<Entry>>();
    	LinkedList<Integer> sums = new LinkedList<Integer>();
    	for (int i = 0; i < num.length; i++) {
    		for (int j = i + 1; j < num.length; j++) {
    			int d = num[i] + num[j];
    			ArrayList<Entry> list = doubles.get(d);
    			if (list == null) {
    				list = new ArrayList<Entry>();
    				doubles.put(d, list);
    				sums.add(d);
    			}
    			list.add(new Entry(i, j));
    		}
    	}
    	for (Integer i : sums) {
    		if (i + i == target) {
    			ArrayList<Entry> list = doubles.get(i);
    			for (int m = 0 ; m < list.size(); m++) {
    				for (int n = m + 1; n < list.size(); n++) {
    					RemoveDup(num, list.get(m), list.get(n), result);
    				}
    			}
    		} else if (target - i > i && doubles.containsKey(target - i)) {
    			ArrayList<Entry> t1 = doubles.get(i);
    			ArrayList<Entry> t2 = doubles.get(target - i);
    			for (Entry e1 : t1) {
    				for (Entry e2 : t2) {
    					RemoveDup(num, e1, e2, result);
    				}
    			}
    		}
    	}
    	return result;
    }
    private void RemoveDup(int[] num, Entry one, Entry two, LinkedList<List<Integer>> result) {
    	int[] a = new int[4];
    	a[0] = one.first;
    	a[1] = one.second;
    	a[2] = two.first;
    	a[3] = two.second;
    	Arrays.sort(a);
    	int i;
    	String hash = "" + num[a[0]];
    	for (i = 0; i <= 2; i++) {
    		if (a[i] == a[i+1])
    			break;
    		hash = hash + num[a[i+1]];
    	}
    	if (i < 3)
    		return;
    	if (!dup.contains(hash)) {
    		dup.add(hash);
    		LinkedList<Integer> r = new LinkedList<Integer>();
    		for (int j : a)
    			r.add(num[j]);
    		result.add(r);
    	}
    }
    public static void main(String[] args) {
    	new Solution().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }
}
