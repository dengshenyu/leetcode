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
    public int jump(int[] A) {
        int[] step = new int[A.length];
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        step[0] = 0;
        int reach = 0;
        while (!list.isEmpty()) {
        	Integer i = list.poll();
        	if (i == A.length - 1)
        		return step[i];
        	int far = i + A[i];
        	if (far > reach) {
        		for (int j = reach+1; j <= far && j < A.length; j++) {
        			step[j] = step[i] + 1;
        			list.add(j);
        		}
        		reach = far;
        	}
        }
        return -1;
    }
}
