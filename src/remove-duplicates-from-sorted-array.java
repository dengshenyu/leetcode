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
        if (A.length == 0)
        	return 0;
        int i = 0, j = 1;
        while (j < A.length) {
        	if (A[i] == A[j])
        		j++;
        	else {
        		i++;
        		A[i] = A[j];
        		j++;
        	}
        }
        return i + 1;
    }
}
