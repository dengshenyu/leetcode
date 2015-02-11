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
    public int maxSubArray(int[] A) {
        int result = Integer.MIN_VALUE;
        int[] s = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        	if (i > 0 && s[i-1] >= 0)
        		s[i] = s[i-1] + A[i];
        	else
        		s[i] = A[i];
        	if (s[i] > result)
        		result = s[i];
        }
        return result;
    }
}
