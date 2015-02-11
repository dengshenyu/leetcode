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
    public int removeDuplicates(int[] A) {
        int wPos = -1, rPos = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (rPos = 0; rPos < A.length; ) {
        	Integer v = map.get(A[rPos]);
        	if (v == null) {
        		v = 1;
        		map.put(A[rPos], v);
        	} else {
        		v++;
        		map.put(A[rPos], v);
        	}
        	if (v <= 2 && wPos != -1) {
        		A[wPos++] = A[rPos++];
        	} else if (v > 2 && wPos == -1) {
        		wPos = rPos;
        		rPos++;
        	} else
        		rPos++;

        }
        if (wPos == -1)
        	return A.length;
        else
        	return wPos;
    }
}
