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
	public List<String> anagrams(String[] strs) {
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String comp = sort(strs[i]);
			LinkedList<String> list = map.get(comp);
			if (list == null) {
				list = new LinkedList<String>();
				map.put(comp, list);
			}
			list.add(strs[i]);
		}
		LinkedList<String> result = new LinkedList<String>();
		for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
			if (entry.getValue().size() >= 2) {
				for (String s : entry.getValue())
					result.add(s);
			}
		}
		return result;
	}
	private String sort(String s) {
		char[] chars = s.toCharArray();
		qsort(chars, 0, chars.length - 1);
		return new String(chars);
	}
	private void qsort(char[] a, int left, int right) {
		if (right <= left)
			return;
		int i = left, j = right;
		int pivot = a[(left+right)/2];
		while (i <= j) {
			while (i <= j && a[j] > pivot)
				j--;
			while (i <= j && a[i] < pivot)
				i++;
			if (i <= j) {
				char tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		if (left < j)
			qsort(a, left, j);
		if (i < right)
			qsort(a, i, right);
	}
	
    public static void main(String[] args) {
    	List<String> a = new Solution().anagrams(new String[]{"tea","and","ace","ad","eat","dans"});
    	for (String s : a)
    		System.out.println("==>" + s + "<===");
    }
}
