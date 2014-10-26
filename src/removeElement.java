package test.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int removeElement(int[] A, int elem) {
    	if (A == null)
    		return 0;
    	int result = A.length;
    	int pos = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] == elem) {
    			result--;
    		}
    		else {
    			A[pos++] = A[i];
    		}
    	}
    	return result;
    }
}
