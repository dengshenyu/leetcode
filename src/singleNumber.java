package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++)
        	result ^= A[i];
        return result;
    }
}
