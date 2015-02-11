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
    public boolean canJump(int[] A) {
    	if (A.length < 2)
    		return true;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int reach = 0;
        list.add(0);
        while (!list.isEmpty()) {
        	Integer i = list.poll();
        	if (i == A.length - 1)
        		return true;
        	if (A[i] + i > reach) {
        		for (int j = reach + 1; j < A.length && j <= A[i] + i; j++)
        			list.add(j);
        		reach = A[i] + i;
        	}
        }
        return false;
    }
}
