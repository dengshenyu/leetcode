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
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String result = "";
        int total = 1;
        for (int i = 1; i <= n; i++) {
        	list.add(i);
        	total *= i;
        }
        while (true) {
        	if (list.size() == 1) {
        		result += list.get(0);
        		return result;
        	} else {
        		int per = total / n;
        		int s;
        		if (k % per == 0)
        			s = k / per;
        		else
        			s = (k / per) + 1;
        		result += list.get(s - 1);
        		list.remove(s - 1);
        		total = per;
        		n--;
        		k -= (s - 1) * per;
        	}
        }

    }
}
